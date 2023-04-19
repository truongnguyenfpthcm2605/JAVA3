/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author truong
 */
public class bai2 extends JFrame implements ActionListener {
    JLabel label;
    JTextField numberOne, numberTwo, result;
    JButton addition, subtraction, multiplication, division;

    public bai2(String title) throws HeadlessException {
        super(title);
        innit();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void innit() {
        int width = 400;
        int height = 220;
        int lwidht = 150;
        int iwidth = 220;
        this.setSize(width, height);

        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);

        // first number
        label = new JLabel("First Number:", JLabel.LEFT);
        label.setBounds(10, 10, lwidht, 30);
        label.setFont(font);
        numberOne = new JTextField();
        numberOne.setBounds(lwidht + label.getX(), label.getY(), iwidth, 30);
        numberOne.setFont(font);
        this.add(label);
        this.add(numberOne);

        // secondNumber
        label = new JLabel("Second Number : ", JLabel.LEFT);
        label.setBounds(numberOne.getX() - lwidht, numberOne.getY() + numberOne.getHeight() + 10, lwidht, 30);
        label.setFont(font);
        this.add(label);
        numberTwo = new JTextField();
        numberTwo.setBounds(lwidht + label.getX(), numberOne.getY() + numberOne.getHeight() + 10, iwidth, 30);
        numberTwo.setFont(font);
        this.add(numberTwo);

        // result 
        label = new JLabel("Result :", JLabel.LEFT);
        label.setBounds(numberTwo.getX() - lwidht, numberTwo.getY() + numberTwo.getHeight() + 10, lwidht, 30);
        label.setFont(font);
        this.add(label);
        result = new JTextField();
        result.setBounds(lwidht + label.getX(), numberTwo.getY() + numberTwo.getHeight() + 10, iwidth, 30);
        result.setFont(font);
        result.setEnabled(false);
        this.add(result);

        // addition
        addition = new JButton("+");
        addition.setBounds(lwidht + label.getX(), height - 80, 50, 30);
        addition.setFont(font);
        addition.addActionListener(this);
        this.add(addition);

        //   subtraction
        subtraction = new JButton("-");
        subtraction.setBounds(addition.getX() + addition.getWidth() + 10, addition.getY(), 40, 30);
        subtraction.addActionListener(this);
        this.add(subtraction);

        // multiplication
        multiplication = new JButton("x");
        multiplication.setBounds(subtraction.getX() + subtraction.getWidth() + 10, addition.getY(), 40, 30);
        multiplication.addActionListener(this);
        this.add(multiplication);

        // division
        division = new JButton("/");
        division.setBounds(multiplication.getX() + multiplication.getWidth() + 10, addition.getY(), 40, 30);
        division.addActionListener(this);
        this.add(division);
       

    }

    public double checkNumber(String num) throws Exception {
        return Double.parseDouble(num);
    }

    public boolean checkNull() {

        if (numberOne.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter First Number  is not Empty !");
            numberOne.setBackground(Color.yellow);
            return false;
        } else if (numberTwo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Second Number  is not Empty  !");
            numberTwo.setBackground(Color.yellow);
            return false;
        }

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkNull()) {
            try {
                double a = checkNumber(numberOne.getText());
                double b = checkNumber(numberTwo.getText());
                double value = 0;
               
                switch (e.getActionCommand()) {
                    case "+":
                        value = a + b;
                        result.setText(String.valueOf(value));
                        break;
                    case "-":
                        value = a - b;
                        result.setText(String.valueOf(value));
                        break;
                    case "x":
                        if (a == 0 || b == 0) {
                            value = 0;
                        } else {
                            value = a * b;
                        }
                        result.setText(String.valueOf(value));
                        break;
                    case "/":
                        if (a == 0 || b == 0) {
                            value = 0;
                        } else {
                            value = a / b;
                        }
                        result.setText(String.valueOf(value));
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter Number is Number not Charactor !");
                numberOne.setText("");
                numberTwo.setText("");
            }
        }

    }

    public static void main(String[] args) {
        new bai2("Calculator").setVisible(true);
    }

}
