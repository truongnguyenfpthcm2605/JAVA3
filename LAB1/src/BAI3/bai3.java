/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI3;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author truong
 */
public class bai3 extends JFrame implements ActionListener {

    JLabel label;
    JTextField txtUser, txtPass, txtConfirm;
    JButton btnSignup, btnCancel;

    public bai3(String title) throws HeadlessException {
        super(title);
        innit();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void innit() {
        int width = 400;
        int height = 220;
        int labelWidth = 130;
        int inputWidth = 220;
        int hegihtTwo = 30;

        this.setSize(width, height);
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);

        // label usename 
        label = new JLabel("UserName: ", JLabel.LEFT);
        label.setBounds(10, 10, labelWidth, hegihtTwo);
        label.setFont(font);
        this.add(label);
        txtUser = new JTextField();
        txtUser.setBounds(label.getX() + labelWidth, label.getY(), inputWidth, hegihtTwo);
        txtUser.setFont(font);
        this.add(txtUser);

        // label password
        label = new JLabel("PassWord : ", JLabel.LEFT);
        label.setBounds(txtUser.getX() - labelWidth, txtUser.getY() + 40, labelWidth, hegihtTwo);
        label.setFont(font);
        this.add(label);
        txtPass = new JTextField();
        txtPass.setBounds(label.getX() + labelWidth, label.getY(), inputWidth, hegihtTwo);
        txtPass.setFont(font);
        this.add(txtPass);

        // label confirm 
        label = new JLabel("confirm : ", JLabel.LEFT);
        label.setBounds(txtPass.getX() - labelWidth, txtPass.getY() + 40, labelWidth, hegihtTwo);
        label.setFont(font);
        this.add(label);
        txtConfirm = new JTextField();
        txtConfirm.setBounds(label.getX() + labelWidth, label.getY(), inputWidth, hegihtTwo);
        txtConfirm.setFont(font);
        this.add(txtConfirm);

        // button sign up
        btnSignup = new JButton("Sign up");
        btnSignup.setFont(font);
        btnSignup.setBounds(txtConfirm.getX(), txtConfirm.getY() + 50, labelWidth - 30, hegihtTwo);
        btnSignup.addActionListener(this);
        this.add(btnSignup);

        // button cancel
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(font);
        btnCancel.setBounds(btnSignup.getX() + btnSignup.getWidth() + 10, txtConfirm.getY() + 50, labelWidth - 30, hegihtTwo);
        btnCancel.addActionListener(this);
        this.add(btnCancel);
    }

    public boolean checkNull() {

        if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Username  is not Empty !");
            txtUser.setBackground(Color.yellow);
            return false;
        } else if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter PassWord  is not Empty  !");
            txtPass.setBackground(Color.yellow);
            return false;
        } else if (txtConfirm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Confirm  is not Empty  !");
            txtConfirm.setBackground(Color.yellow);
            return false;
        }
        return true;
    }

    public boolean checkPassToConfirm() {
        if (!txtPass.getText().equals(txtConfirm.getText())) {
            JOptionPane.showConfirmDialog(this, "Mât Khâu Phai trung voi xã nhân");
            txtPass.setText("");
            txtConfirm.setText("");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String control = e.getActionCommand();
            
            if(control.equals(btnSignup.getText())){
                if(checkNull()){
                    if(checkPassToConfirm()){
                        JOptionPane.showMessageDialog(this, "Sgin up Successfull!");
                    }
                }
            }else if(control.equals(btnCancel.getText())){
                int a =  JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit!", JOptionPane.YES_NO_OPTION);
                if(a== JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
    }

    public static void main(String[] args) {
        new bai3("Bài 3").setVisible(true);
    }

}
