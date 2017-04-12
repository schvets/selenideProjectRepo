package com.selenium.test.tools;

import java.sql.*;


/**
 * Created by 485 on 12.04.2017.
 */
public class DbfProcessor {
    public void dbfProcessor(String filePath) throws SQLException {
        try {
            Class.forName("com.hxtt.sql.dbf.DBFDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = DriverManager.getConnection("jdbc:dbf:/" + filePath.substring(0, 8));
        String qry = "select COUNT(ROUTE_REPO) AS total FROM " + filePath.substring(8, 28) + " WHERE ROUTE_REPO=506205";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qry);
        while (rs.next()) {
            System.out.println(rs.getInt("total"));
        }
        rs.close();
        st.close();
        con.close();
    }
}
