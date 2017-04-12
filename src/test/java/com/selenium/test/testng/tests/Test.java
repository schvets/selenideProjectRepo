package com.selenium.test.testng.tests;

import com.selenium.test.tools.DbfProcessor;
import com.selenium.test.tools.FileGetter;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by 485 on 12.04.2017.
 */
public class Test {
    private static final String DEST_DIR = "C:\\test";
    private static final String ZIP_DIR = "C:\\Users\\485\\Downloads";

    public static void main(String[] args) throws SQLException {
/*        FileUnzipTools fileUnzipTools = new FileUnzipTools();
        try {
            fileUnzipTools.unZip(ZIP_DIR,DEST_DIR);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



/*        DbfProcessor dbfProcessor = new DbfProcessor();
        dbfProcessor.dbfProcessor(ZIP_DIR);*/
        FileGetter fileGetter = new FileGetter();
        ArrayList<String> fileList = fileGetter.getAllFilesFromPathByMask(DEST_DIR, "dbf");
        for (String file : fileList) {
            DbfProcessor dbfProcessor = new DbfProcessor();
            dbfProcessor.dbfProcessor(file);
        }
    }
}
