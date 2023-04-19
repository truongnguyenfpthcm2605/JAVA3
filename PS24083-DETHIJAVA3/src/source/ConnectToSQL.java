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
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=store;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        Connection com = DriverManager.getConnection(dbURL, user, pass);
        return com;
    }

    public List<Store> getAllData() throws Exception {
        String select = "select * from manager";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(select);) {
            try ( ResultSet rs = pmst.executeQuery()) {
                List<Store> list = new ArrayList<>();
                while (rs.next()) {
                    Store sv = new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7));
                    list.add(sv);
                }
                return list;
            }
        }
    }

    public boolean save(Store sv) throws Exception {
        String save = "insert into manager values(?,?,?,?,?,?,?)";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(save);) {
            pmst.setString(1, sv.getMaHoaDon());
            pmst.setString(2, sv.getMaHang());
            pmst.setString(3, sv.getTenHang());
            pmst.setString(4, sv.getNgayMua());
            pmst.setInt(5, sv.getSoluong());
            pmst.setFloat(6, sv.getDongia());
            pmst.setFloat(7, sv.getThanhtien());
            return pmst.executeUpdate() > 0;
        }
    }

    public boolean update(Store sv) throws Exception {
        String update = "update manager set maHang =?, tenHang =?,ngaymua=?,soluong = ?,dongia= ?,thanhtien = ? where maHoadon =?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(update);) {
            pmst.setString(1, sv.getMaHang());
            pmst.setString(2, sv.getTenHang());
            pmst.setString(3, sv.getNgayMua());
            pmst.setInt(4, sv.getSoluong());
            pmst.setFloat(5, sv.getDongia());
            pmst.setFloat(6, sv.getThanhtien());
            pmst.setString(7, sv.getMaHoaDon());
            return pmst.executeUpdate() > 0;
        }
    }

    public Store findID(String id) throws Exception {
        String find = "select * from manager where maHoadon = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(find);) {
            pmst.setString(1, id);
            try ( ResultSet rs = pmst.executeQuery()) {
                while (rs.next()) {
                    Store sv = new Store(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getInt(5), rs.getFloat(6), rs.getFloat(7));
                    return sv;
                }
            }
        }
        return null;
    }

    public boolean delete(String id) throws Exception {
        String delete = "delete from manager where maHoadon  = ?";
        try (
                 Connection con = getConnection();  PreparedStatement pmst = con.prepareStatement(delete);) {
            pmst.setString(1, id);
            return pmst.executeUpdate() > 0;
        }
    }

}
