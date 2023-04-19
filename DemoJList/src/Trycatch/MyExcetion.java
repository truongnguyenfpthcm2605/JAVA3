/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trycatch;

/**
 *
 * @author truong
 */
public class MyExcetion extends  Exception{
    int a,b;

    public MyExcetion(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getMessage() {
        return "Erorr Division by Zero";
    }
    
}
