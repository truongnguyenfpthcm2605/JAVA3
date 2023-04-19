/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author truong
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            // tao server
            ServerSocket server = new ServerSocket(8888);
            System.out.println("Server is Connecting .....");
            // tao ket noi cho
            Socket socket = server.accept();
            System.out.println("Server is connect ");
            // luong doc du lieu
            DataInputStream input = new DataInputStream(socket.getInputStream());
            // luong ghi du lieu
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            while (true) {
                // doc so thu nhat
                double number1 = input.readDouble();
                // doc so thu 2
                double number2 = input.readDouble();
                // thong bao da doc dc
                System.out.println("Two number from to Client is : " + number1 + " "+ number2 );
                double sum= number1+number2;
                /// tra lai tong
                output.writeDouble(sum);
                // day du lieu di khoi diem
                output.flush();
                // thong bao ket qua tong tu 2 du lieu doc duoc
                System.out.println("Sum of it's : " + sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
