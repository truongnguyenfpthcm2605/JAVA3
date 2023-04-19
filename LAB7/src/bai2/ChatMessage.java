/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author truong
 */
public class ChatMessage {
    private Socket socket ;
    private JTextPane text ;
    private PrintWriter writer ;
    private BufferedReader read;

    public ChatMessage(Socket socket, JTextPane text) throws IOException {
        this.socket = socket;
        this.text = text;
        
        writer = new PrintWriter(socket.getOutputStream());
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        recive();
        
    }

    public void recive(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    String line = read.readLine();
                    if(line!=null){
                        text.setText(text.getText() + "\n"+ line);
                    }
                } catch (Exception e) {
                }
                
            }
        };
        thread.start();
    }
    public void Send(String ms){
        String current = text.getText();
        text.setText(current + "\nSend: " + ms);
        writer.println(ms);
        writer.flush();
    }
    public void close(){
        try {
            read.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    
    
    
}
