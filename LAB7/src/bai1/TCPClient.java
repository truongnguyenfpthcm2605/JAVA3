/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author truong
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client is connecting.....");
            // ket noi cong server
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Client is connect");
            // tao luong ghi va luong doc
            DataOutputStream output=  new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            while (true) {  
                
                Scanner sc = new Scanner(System.in);
                // ghi vao so thu nhat
                System.out.println("Input number first :");
                double number1 = sc.nextDouble();
                output.writeDouble(number1);
                //day di toi server
                output.flush();
                // ghi so thu 2
                  System.out.println("Input number Second :");
                double number2 = sc.nextDouble();
                output.writeDouble(number2);
                // daty di toi server
                output.flush();
               // doc du lieu tu server tra ve
                System.out.println("Sum of it's : " + input.readDouble());
                sc =new Scanner(System.in);
                System.out.println("do you want continue : ");
                String answer  = sc.nextLine();
                if(answer.equalsIgnoreCase("n")){
                    break;
                }

                
            }
            
        } catch (Exception e) {
        }
    }
}
