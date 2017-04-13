package com.selenium.test.utils;

import java.sql.*;

/*http://508a.ru/crack-hxtt/*/

/**
 * Created by 485 on 12.04.2017.
 */
public class DbfProcessor {
    public void dbfProcessor(String filePath) {
        try {
            Class.forName("com.hxtt.sql.dbf.DBFDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:dbf:/" + filePath.substring(0, 15));
            String qry = "select TOP 10000 * FROM " + filePath.substring(16, 36);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                int i = 1;
                System.out.println(i + " " +
                        rs.getString("POINT_NAME") + " " + rs.getInt("ROUTE_REPO"));
                i++;
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dbfProcessorTest(String filePath) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String connString = "jdbc:odbc:Driver={Microsoft dBASE Driver (*.dbf)};DefaultDir=" + filePath.substring(0, 8);//DeafultDir indicates the location of the db
            Connection con = DriverManager.getConnection(connString);
            String qry = "SELECT * FROM table_name where condition";// usual sql query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                System.out.println(rs.getInt("total"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

