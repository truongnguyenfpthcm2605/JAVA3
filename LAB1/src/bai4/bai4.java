/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author truong
 */
public class bai4 extends JFrame implements ActionListener {

    JButton but1, but2, but3, reset;
    JTextField text1, text2;
    JLabel label;
    int sum;

    public bai4(String title) throws HeadlessException {
        super(title);
        innit();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void innit() {
        int width = 320;
        int height = 200;
        int widthButton = 80;
        this.setSize(width, height);

        this.setLayout(null);

        text1 = new JTextField();
        text1.setBounds(10, 10, 60, 30);
        text1.setEnabled(false);
        text1.setForeground(Color.red);
        this.add(text1);

        // label 
        label = new JLabel("+");
        label.setBounds(text1.getX() + text1.getWidth() + 20, 20, 20, 20);
        this.add(label);
      

        text2 = new JTextField();
        text2.setBounds(label.getX() + label.getWidth() + 20, 10, 60, 30);
        text2.setEnabled(false);
        text2.setForeground(Color.red);
        this.add(text2);

        but1 = new JButton();
        but1.setBounds(10, 80, widthButton, 20);
        but1.addActionListener(this);
        this.add(but1);

        but2 = new JButton();
        but2.setBounds(but1.getX() + but1.getWidth() + 20, 80, widthButton, 20);
        but2.addActionListener(this);
        this.add(but2);

        but3 = new JButton();
        but3.setBounds(but2.getX() + but2.getWidth() + 20, 80, widthButton, 20);
        but3.addActionListener(this);
        this.add(but3);

        label = new JLabel(" Please Choose Number ");
        label.setBounds(but1.getX() + but1.getWidth(), but2.getHeight() + 80, 150, 30);
        label.setForeground(Color.GREEN);
        this.add(label);

        reset = new JButton("Reset");
        reset.setBounds(but1.getX() + but1.getWidth() + 20, but3.getHeight() + 120, 80, 20);
        reset.addActionListener(this);
        this.add(reset);
        create();

    }

    public void create() {
        Random ran = new Random();
        int a = ran.nextInt(100);
        int b = ran.nextInt(100);
        sum = a + b;
        text1.setText(String.valueOf(a));
        text2.setText(String.valueOf(b));
        but1.setText(String.valueOf(sum - ran.nextInt(100) + ran.nextInt(100)));
        but2.setText(String.valueOf(sum - ran.nextInt(100) + ran.nextInt(100)));
        but3.setText(String.valueOf(sum - ran.nextInt(100) + ran.nextInt(100)));

        int location = ran.nextInt(3);
        switch (location) {
            case 0:
                but1.setText(String.valueOf(sum));
                break;
            case 1:
                but2.setText(String.valueOf(sum));
                break;
            case 2:
                but3.setText(String.valueOf(sum));
                break;
            default:
                throw new AssertionError();
        }

    }

    public void Answer(String a) {
        if (a.equals(String.valueOf(sum))) {
            JOptionPane.showMessageDialog(this, "True");
        } else {
            JOptionPane.showMessageDialog(this, "False");
        }
    }

    public void function() {
        JOptionPane.showMessageDialog(this, "Kh");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals(reset.getText())) {
            create();
        } else if (str.equals(but1.getText())) {
            Answer(but1.getText());
        } else if (str.equals(but2.getText())) {
            Answer(but2.getText());
        } else if (str.equals(but3.getText())) {
            Answer(but3.getText());
        }

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager. getSystemLookAndFeelClassName());
            new bai4("Bai4").setVisible(true);
        } catch (Exception e) {
        }
    }

}
