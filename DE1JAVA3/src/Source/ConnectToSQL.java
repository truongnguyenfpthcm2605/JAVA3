/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author truong
 */
public class ConnectToSQL {

    public static Connection getConnection() throws Exception {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=de1java3;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        Connection com = DriverManager.getConnection(dbURL, user, pass);
        return com;

    }

    public boolean save(Studnet sv) throws Exception {
        String save = "insert into sinhvien values (?,?,?,?,?,?)";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(save);) {
            pmst.setString(1, sv.getID());
            pmst.setString(2, sv.getName());
            pmst.setString(3, sv.getDate());
            pmst.setString(4, sv.getPhone());
            pmst.setBoolean(5, sv.isGender());
            pmst.setString(6, sv.getAddress());
            return pmst.executeUpdate() > 0;
        }
    }

    public boolean update(Studnet sv) throws Exception {
        String update = "update sinhvien set hoten = ?,ngaysinh = ?,sodt = ?,gioitinh =?,diachi = ? where masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(update);) {
            pmst.setString(1, sv.getName());
            pmst.setString(2, sv.getDate());
            pmst.setString(3, sv.getPhone());
            pmst.setBoolean(4, sv.isGender());
            pmst.setString(5, sv.getAddress());
            pmst.setString(6, sv.getID());
            return pmst.executeUpdate() > 0;
        }
    }

    public boolean delete(String id) throws Exception {
        String delete = "delete from sinhvien where masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(delete);) {
            pmst.setString(1, id);
            return pmst.executeUpdate() > 0;
        }
    }

    public List<Studnet> getAllData() throws Exception {
        String select = "select * from sinhvien";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(select);) {
            try ( ResultSet rs = pmst.executeQuery()) {
                List<Studnet> list = new ArrayList<>();
                while (rs.next()) {
                    Studnet sv = new Studnet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
                    list.add(sv);
                }
                return list;
            }
        }
    }

    public Studnet findID(String id) throws Exception {
        String find = "select * from sinhvien where masv = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(find);) {
            pmst.setString(1, id);
            try ( ResultSet rs = pmst.executeQuery()) {
                while (rs.next()) {
                    Studnet sv = new Studnet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
                    return sv;
                }
            }
        }
        return null;
    }
}
