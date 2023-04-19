/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package string;

/**
 *
 * @author truong
 */
public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append("Hello Everyone");
        System.out.println(str.capacity());
        System.out.println(str.length());
        System.out.println(str.charAt(4)); // vi tri tai
        System.out.println(str.indexOf("s"));// vi tri dau tien xuat hien
        System.out.println(str.lastIndexOf("E")); // vi tri cuoi cung xuat hien
        System.out.println(str.insert(3, "dddd"));
        System.out.println(str);
    }
}
