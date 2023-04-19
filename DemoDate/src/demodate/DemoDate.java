/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demodate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author truong
 */
public class DemoDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date = null;
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
     
        try {
            System.out.print("Input Date :");
            date = simple.parse(new Scanner(System.in).nextLine());
        } catch (Exception e) {
        }
        System.out.println(date);
        System.out.println(simple.format(date));
        
    }
    
}
