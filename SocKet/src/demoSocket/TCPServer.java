/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author truong
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789);
            System.out.println("Listening......");
            // su dung vong lap tiep thu cc yeu ca utu client
            while(true){
                    Socket socket = server.accept(); // lang nghe yeeu cau tu client thi tao socket
                    BufferedReader reader = new BufferedReader(new  InputStreamReader(socket.getInputStream()));
                    // lay luong doc du lieu cua socket
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    // ghi du lieu doc doc cua soket
                    
                    String line = reader.readLine();
                    // lay du lieu doc dc chuyen ve client
                    System.out.println("Send..........");
                    out.println(line.toUpperCase());
                    out.flush();
                    // day du lieu ddi khoi bo nho dem
                    
                    reader.close();
                    out.close();
                    socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
