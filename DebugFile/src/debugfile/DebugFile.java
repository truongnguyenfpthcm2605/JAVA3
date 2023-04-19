/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package debugfile;

import java.util.Random;

/**
 *
 * @author truong
 */
public class DebugFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random ran = new Random();
         int a =ran.nextInt(10);
         for (int i = 0; i < 10; i++) {
             a+=i;
             System.out.println(a);
        }
    }
    
}
