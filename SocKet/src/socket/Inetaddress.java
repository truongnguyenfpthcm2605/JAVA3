/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socket;

import java.net.InetAddress;

/**
 *
 * @author truong
 */
public class Inetaddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress in = InetAddress.getLocalHost();
            System.out.println(in.getHostAddress());
            System.out.println(in.getHostName());
        } catch (Exception e) {
        }
        try {
            InetAddress[] inet = InetAddress.getAllByName("dantri.com.vn");
            for (int i = 0; i < inet.length; i++) {
                System.out.println("Address : " + (i + 1) + " : " + inet[i].getHostName());
                System.out.println("Address : " + (i + 1) + " : " + inet[i].getHostAddress());
            }
        } catch (Exception e) {
        }
    }

}
