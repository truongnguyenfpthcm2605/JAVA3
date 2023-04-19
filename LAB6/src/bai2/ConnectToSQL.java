/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.sql.*;

/**
 *
 * @author truong
 */
public class ConnectToSQL {

    public Connection Connect() throws Exception {
        String sql = "jdbc:sqlserver://localhost:1433;databaseName=BAI2LAB6;encrypt=true;trustServerCertificate=true";
        Connection com = DriverManager.getConnection(sql, "sa", "12345");
        return com;
    }

    public Student getStudent(String name) throws Exception {
        String sql = "select name,address,parentname,phone, standards.stand,fees from students join standards on standards.stand = students.stand   where name = ?";
        try (
                 Connection com = Connect();  PreparedStatement pmst = com.prepareStatement(sql);) {
            pmst.setString(1, name.trim());
            try ( ResultSet rs = pmst.executeQuery()) {
                if (rs.next()) {
                    Student sv = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getFloat(6));
                    return sv;
                }
            }

        }
        return null;
    }

    public boolean addStudent(Student sv, String stand) throws Exception {
        String insert = "insert into students(name,address,parentname,phone,stand,date) values (?,?,?,?,?,null)";
        try (
                 Connection com = Connect();  PreparedStatement pmst = com.prepareStatement(insert);) {
            pmst.setString(1, sv.getName());
            pmst.setString(2, sv.getAddress());
            pmst.setString(3, sv.getParenName());
            pmst.setString(4, sv.getPhone());
            pmst.setString(5, stand);
            return pmst.executeUpdate() > 0;

        }
    }

    public Boolean Update(Student sv, String stand, String name) throws Exception {
        String insert = "update students set name =?, address =?,parentname =?,phone =?,stand =? where name = ?";
        try (
                 Connection com = Connect();  PreparedStatement pmst = com.prepareStatement(insert);) {
            pmst.setString(1, sv.getName());
            pmst.setString(2, sv.getAddress());
            pmst.setString(3, sv.getParenName());
            pmst.setString(4, sv.getPhone());
            pmst.setString(5, stand);
            pmst.setString(6, name);
            return pmst.executeUpdate() > 0;

        }

    }

    public boolean checkNumberPhone(String s) {
        String parttern = "0[932]\\d{8}";
        return s.matches(parttern);
    }

    public Boolean Delete(String name) throws Exception {
        String delete = "delete from students where name = ?";
        try (
                 Connection com = Connect();  PreparedStatement pmst = com.prepareStatement(delete);) {
            pmst.setString(1, name);
            return pmst.executeUpdate() > 0;
        }

    }
}
