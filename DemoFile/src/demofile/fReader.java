/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author truong
 */
public class fReader {

    public static void main(String[] args) {
        File file = new File("D:\\vidu.txt");
        FileReader reader = null;
        BufferedReader buf = null;
        
        try {
            reader = new FileReader(file);
            buf = new BufferedReader(reader);
            StringBuilder str  = new StringBuilder();
            while (true) {                
                try {
                    String read = buf.readLine();
                    if(read == null){
                        break;
                    }
                    str.append(read);
                } catch (Exception e) {
                }
            }
            System.out.println(str);
            buf.close();
            reader.close();
        } catch (Exception e) {
        }
    }
}
