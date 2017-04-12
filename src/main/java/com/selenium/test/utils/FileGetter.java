package com.selenium.test.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by 485 on 12.04.2017.
 */
public class FileGetter {
    public ArrayList<String> getAllFilesFromPathByMask(String path, String fileMask) {
        ArrayList<String> fileNames = new ArrayList<String>();
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    if (filePath.toString().endsWith(fileMask)) {
                        fileNames.add(filePath.toString());
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileNames;
    }
}
