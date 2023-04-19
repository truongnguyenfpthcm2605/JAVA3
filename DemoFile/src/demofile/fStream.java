/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author truong
 */
public class fStream {
    public static void main(String[] args) {
        File file = new File("D:\\vidu.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            Scanner sc = new Scanner(System.in);
            String writer;
            for (int i = 0; i < 3; i++) {
                System.out.print("Insert to file: ");
                writer = sc.nextLine() + "\n";
                byte[] bi = writer.getBytes();
                out.write(bi);
            }
            out.close();
            
        } catch (Exception e) {
        }
        
        try {
            FileInputStream input = new FileInputStream(file);
            StringBuilder str = new StringBuilder();
            while (true) {                
                int read = input.read();
                if(read<0){
                    break;
                }
                char translate = (char)read;
                str.append(translate);
            }
        
            System.out.println(str.toString());
        } catch (Exception e) {
        }
        
    }
}
