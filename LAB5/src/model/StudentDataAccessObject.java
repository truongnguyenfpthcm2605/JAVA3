/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author truong
 */
public class StudentDataAccessObject {

    public Connection openConnection() throws Exception {
        // tao ket noi voi csdl 
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        Connection com = DriverManager.getConnection(dbURL, user, pass);
        // tra ve ket noi
        return com;
    }

    public boolean InsertStudent(Student sv) throws Exception {
        // thuc hien cau len them moi insert into
        String insert = "insert into students(Masv,Hoten,Email,SoDT,GioiTinh,Diachi) values(?,?,?,?,?,?)";
        try (
                 Connection con = openConnection();  PreparedStatement pstmt = con.prepareStatement(insert);) {
            // gan cac du lieu cua classs student vao cau lenh truy van
            pstmt.setString(1, sv.getCodeStudent());
            pstmt.setString(2, sv.getFullName());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getPhone());
            pstmt.setBoolean(5, sv.isGender());
            pstmt.setString(6, sv.getAddress());
            // neu > 0 la true 
            return pstmt.executeUpdate() > 0;

        }

    }

    public Student FindStudent(String Masv) throws Exception {
        String query = "select * from STUDENTS where Masv = ?";
        try (
                 Connection con = openConnection();  PreparedStatement pstmt = con.prepareStatement(query);) {

            pstmt.setString(1, Masv);

            ResultSet re = pstmt.executeQuery();
            // vong lap la co du lieu duoc truy van
            if (re.next()) {
                
              Student sv = new Student();
              sv.setCodeStudent(re.getString("Masv"));
              sv.setFullName(re.getString("Hoten"));
              sv.setEmail(re.getString("Email"));
              sv.setPhone(re.getString("SoDT"));
              sv.setGender(re.getBoolean("GioiTinh"));
              sv.setAddress(re.getString("Diachi"));
                return sv;
            }
        }
        return null;

    }
     public boolean UpdateStudent(Student sv) throws Exception {
        String update = "update students set Hoten = ? ,Email = ? ,SoDt = ? ,GioiTinh = ?,Diachi = ?  where Masv = ?";
        try (
                 Connection con = openConnection();  PreparedStatement pstmt = con.prepareStatement(update);) {
            pstmt.setString(6, sv.getCodeStudent());
            pstmt.setString(1, sv.getFullName());
            pstmt.setString(2, sv.getEmail());
            pstmt.setString(3, sv.getPhone());
            pstmt.setBoolean(4, sv.isGender());
            pstmt.setString(5, sv.getAddress());
            return pstmt.executeUpdate() > 0;

        }

    }
       public boolean DeleteStudent(String Masv) throws Exception {
        String delete = "delete from students where Masv = ?";
        try (
                 Connection con = openConnection();  PreparedStatement pstmt = con.prepareStatement(delete);) {
          pstmt.setString(1, Masv);
            return pstmt.executeUpdate() > 0;

        }

    }
}
