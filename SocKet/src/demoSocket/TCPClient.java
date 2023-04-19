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
import java.util.Scanner;

/**
 *
 * @author truong
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 6789);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // lay luong doc du lieu cua socket
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            // ghi du lieu doc doc cua soket
            Scanner sc = new Scanner(System.in);
            // gui du lieu toi server
            System.out.println("Enter a liner : ");
            String st = sc.nextLine();
            System.out.println("Send...");
            out.println(st);
            // do du lieu trong bo diem di
            out.flush();
            String line = reader.readLine();
            System.out.println(line);
            // lay du lieu doc dc chuyen ve client

            // day du lieu ddi khoi bo nho dem

            reader.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
