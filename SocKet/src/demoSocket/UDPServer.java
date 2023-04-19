/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author truong
 */
public class UDPServer {

    public static void main(String[] args) {
        try {
            System.out.println("Listening");
            DatagramSocket datagramSocket = new DatagramSocket(8079);
            byte[] reader = new byte[1024];
            byte[] writer = null;

            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(reader, reader.length);
                datagramSocket.receive(datagramPacket); // nhan noi dung

                String line = new String(datagramPacket.getData());
                System.out.println("Da Nhan" + line);
                // chuyen noi dung thanh chuoi

                writer = line.toUpperCase().getBytes(); // lay noi dung in hoa chuyen thanh byte
                InetAddress host = datagramPacket.getAddress(); // lay dia chia vua nhan
                int port = datagramPacket.getPort(); // lay port

                DatagramPacket sendpk = new DatagramPacket(writer, writer.length, host, port);
                System.out.println("Da send : " + line.toUpperCase());
                datagramSocket.send(sendpk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
