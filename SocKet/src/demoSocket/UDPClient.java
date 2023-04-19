/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author truong
 */
public class UDPClient {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a line :");
            String st = sc.nextLine();

            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] reader = new byte[1024];
            byte[] writer = null;

            InetAddress host =InetAddress.getByName("localhost"); // lay dia chia vua nhan
            int port = 8079;// lay port
            writer = st.getBytes();
            DatagramPacket sendpk = new DatagramPacket(writer, writer.length, host, port);
            System.out.println("Da send : " + st.toUpperCase());
            datagramSocket.send(sendpk);

            DatagramPacket datagramPacket = new DatagramPacket(reader, reader.length);
            datagramSocket.receive(datagramPacket); // nhan noi dung

            String line = new String(datagramPacket.getData());
            System.out.println("Da Nhan" + line);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
