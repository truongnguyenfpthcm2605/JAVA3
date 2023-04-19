/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author truong
 */
public class MyCalcculator  extends JFrame{

    public MyCalcculator(String title) throws HeadlessException {
        super(title);
        this.setSize(300, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        this.setVisible(true);
    }

    private void init() {
        JTextField jtext = new JTextField();
        jtext.setSize(200,100);
        this.setLayout(null);
        JPanel jp1,jpa2;
        
        jpa2 = new JPanel(new GridLayout(4, 4) );
      JButton button;
        for (int i = 0; i < 12; i++) {
         button = new JButton(""+i);
            jpa2.add(button);
            
        }
        this.add(jp1);
        this.add(jpa2);
    }
    public static void main(String[] args) {
        new MyCalcculator("My Casio");
    }
    
}
