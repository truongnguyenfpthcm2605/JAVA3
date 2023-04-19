/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.sql.*;

/**
 *
 * @author truong
 */
public class BooksDAO {

    public Connection ConnectToSQl() throws Exception {
        String sql = "jdbc:sqlserver://localhost:1433;databaseName=BOOK;encrypt=true;trustServerCertificate=true";
        Connection com = DriverManager.getConnection(sql, "sa", "12345");
        return com;
    }

}
