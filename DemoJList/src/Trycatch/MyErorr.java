/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trycatch;

/**
 *
 * @author truong
 */
public class MyErorr {
    public static int Division(int a, int b) throws MyExcetion{
       if(b==0){
           throw  new MyExcetion(a, b);
       }else{
           return a/b;
       }
    }
    public static void main(String[] args) {
        try {
           int a = Division(5, 0);
            System.out.println(a);
        } catch (MyExcetion e) {
            System.out.println(e.getMessage());
        }
    }
}
