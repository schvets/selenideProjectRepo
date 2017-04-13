package com.selenium.test.utils;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by 485 on 12.04.2017.
 */
public class FileUnzipTools {
    private static final int BUFFER_SIZE = 4096;

    public void unZip(String zipFilePath, String destDirectory) {
        FileGetter fileGetter = new FileGetter();
        ArrayList<String> filesPath = fileGetter.getAllFilesFromPathByMask(zipFilePath, ".zip");
        for (String zipFile : filesPath) {
            File destDir = new File(destDirectory);
            if (!destDir.exists()) {
                destDir.mkdir();
            }
            ZipInputStream zipIn = null;
            try {
                zipIn = new ZipInputStream(new FileInputStream(zipFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ZipEntry entry = null;
            try {
                entry = zipIn.getNextEntry();

                // iterates over entries in the zip file
                while (entry != null) {
                    String filePath = destDirectory + File.separator + entry.getName();
                    Format dateFormat = new SimpleDateFormat("yyyy MM dd");
                    Date curentDate = new Date();
                    boolean isCurrentFileCorrect = dateFormat.format(curentDate).equals(dateFormat.format(entry.getTime()));
                    if (!entry.isDirectory() && isCurrentFileCorrect) {
                        // if the entry is a file, extracts it
                        extractFile(zipIn, filePath);
                    }
                    zipIn.closeEntry();
                    entry = zipIn.getNextEntry();
                }
                zipIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}


