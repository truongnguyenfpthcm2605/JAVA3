/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truong
 */
public class ConnectToSQL {

    public Connection getConnection() throws Exception {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        Connection com = DriverManager.getConnection(dbURL, user, pass);
        return com;
    }

    public boolean save(Student sv) throws Exception {
        String save = "insert into students values (?,?,?,?,?,?)";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(save);) {
            pmst.setString(1, sv.getId());
            pmst.setString(2, sv.getName());
            pmst.setString(3, sv.getEmail());
            pmst.setString(4, sv.getPhone());
            pmst.setBoolean(5, sv.isGender());
            pmst.setString(6, sv.getAddress());
            return pmst.executeUpdate() > 0;
        }
    }

    public boolean update(Student sv) throws Exception {
        String update = "update STUDENTS set Hoten =?, Email = ?,SoDT = ?,GioiTinh =?,Diachi =? where Masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(update);) {
            pmst.setString(1, sv.getName());
            pmst.setString(2, sv.getEmail());
            pmst.setString(3, sv.getPhone());
            pmst.setBoolean(4, sv.isGender());
            pmst.setString(5, sv.getAddress());
            pmst.setString(6, sv.getId());
            return pmst.executeUpdate() > 0;
        }
    }
      public boolean delete(String id) throws Exception {
        String delete = "delete from students where masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(delete);) {
            pmst.setString(1, id);
            return pmst.executeUpdate() > 0;
        }
    }

    public List<Student> getAllData() throws Exception {
        String select = "select * from students";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(select);) {
            try ( ResultSet rs = pmst.executeQuery()) {
                List<Student> list = new ArrayList<>();
                while (rs.next()) {
                    Student sv = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
                    list.add(sv);
                }
                return list;
            }
        }
    }

    public Student findID(String id) throws Exception {
        String find = "select * from students where masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(find);) {
            pmst.setString(1, id);
            try ( ResultSet rs = pmst.executeQuery()) {
                while (rs.next()) {
                    Student sv = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
                    return sv;
                }
            }
        }
        return null;
    }
}
