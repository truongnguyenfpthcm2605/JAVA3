/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

/**
 *
 * @author truong
 */
public class Student {
    private String name;
    private String address;
    private String parenName;
    private String phone;
    private String stand;
    private float fees;

    public Student() {
    }

    public Student(String name, String address, String parenName, String phone, String stand, float fees) {
        this.name = name;
        this.address = address;
        this.parenName = parenName;
        this.phone = phone;
        this.stand = stand;
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParenName() {
        return parenName;
    }

    public void setParenName(String parenName) {
        this.parenName = parenName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    

}