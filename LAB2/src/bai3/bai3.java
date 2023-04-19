/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author truong
 */
public class bai3 extends JFrame implements ActionListener {

    public bai3(String title) throws HeadlessException {
        super(title);
        init();
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        Font font = new Font("Eras Medium ITC", Font.BOLD, 20);

        JButton shows, input, confirm, option;
        shows = new JButton("ShowMessageDialog");
        shows.setFont(font);
        shows.setForeground(Color.red);
        shows.addActionListener(this);
        input = new JButton("InputDialog");
        input.setFont(font);
        input.setForeground(Color.green);
        input.addActionListener(this);
        confirm = new JButton("ConfirmDialog");
        confirm.setFont(font);
        confirm.setForeground(Color.yellow);
        confirm.addActionListener(this);
        option = new JButton("OptionDialog");
        option.setFont(font);
        option.setForeground(Color.LIGHT_GRAY);
        option.addActionListener(this);

        JPanel panelcenter = new JPanel(new GridLayout(4,1));
        panelcenter.add(shows);
        panelcenter.add(input);
        panelcenter.add(confirm);
        panelcenter.add(option);
        panelcenter.setSize(200, 200);

        this.add(panelcenter, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String contr = e.getActionCommand();
        if (contr.equals("ShowMessageDialog")) {
            JOptionPane.showMessageDialog(this, "Please Input YourName!");
        } else if (contr.equals("InputDialog")) {
            String name = JOptionPane.showInputDialog(this, "Input Your Name: ");
            if(name!= null){
                JOptionPane.showMessageDialog(this, "Your Name : " + name);
            }
        } else if (contr.equals("ConfirmDialog")) {
            int choose = JOptionPane.showConfirmDialog(this, "Are you sure", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(choose == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "Sure");
            }else{
                 JOptionPane.showMessageDialog(this, " Not Sure");
            }
        } else {
            
            String[] option ={"Jave","Python","C++","PHP","Javascript","C#"};
            int code = JOptionPane.showOptionDialog(this, "What language is your study?", "Option Box", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, option,option[0]);
            JOptionPane.showMessageDialog(this, "Answer : " +code);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new bai3("dd").setVisible(true);
        } catch (Exception e) {
        }
    }

}
