/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demomail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author truong
 */
public class test {
     public static Connection getConnection() throws SQLException {
        String connection = "jdbc:sqlserver://localhost:1433;databaseName=ActionMovie;encrypt=true;trustServerCertificate=true";
        Connection com = DriverManager.getConnection(connection, "sa", "123456");
        return com;
    }
     public static void main(String[] args) {
         try {
             if(getConnection()!=null){
                 System.out.println("Thanh Cong");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
