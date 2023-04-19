/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

/**
 *
 * @author truong
 */
public class Store {
    private String maHoaDon;
    private String maHang;
   private String tenHang;
    private String NgayMua;
    private int soluong;
    private float dongia;
    private float thanhtien;

    public Store() {
    }

    public Store(String maHoaDon, String maHang, String tenHang, String date, int soluong, float dongia, float thanhtien) {
        this.maHoaDon = maHoaDon;
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.NgayMua = date;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String date) {
        this.NgayMua = date;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
