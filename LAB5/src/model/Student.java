    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author truong
 */
public class Student  {
    private String CodeStudent ;
    private String fullName;
    private String email;
    private String phone;
    private boolean gender;
    private String address;

    public Student(String CodeStudent, String fullName, String email, String phone, boolean gender,String address) {
        this.CodeStudent = CodeStudent;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public Student() {
    }
    

    public String getCodeStudent() {
        return CodeStudent;
    }

    public void setCodeStudent(String CodeStudent) {
        this.CodeStudent = CodeStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    
}
