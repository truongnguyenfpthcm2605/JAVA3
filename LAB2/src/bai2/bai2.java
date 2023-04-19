/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author truong
 */
public class bai2 extends JFrame implements ActionListener {

    public JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnaddandsub, btnC, btnadd, btnsub, btnmulti, btndivison, btnSqrt,
            btnPercent, btn1diX, btnresult, btnDelete, btnOn, btnOff, btnx2, btnAC;
    JPanel panelCalculator, panelBrand, panelCenter;
    public JLabel label;
    public JTextField txtSreen;
    public JRadioButton rdoOn, rdoOff;
    boolean blank = false;
    long a = 0;
    String pheptinh = "", toanTu1 = "";

    public bai2(String title) throws HeadlessException {
        super(title);
        init();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        this.setSize(350, 450);
        this.setLayout(new BorderLayout());
        // ActionListenner
        Font f = new Font("Arial", Font.BOLD, 30);
        Font f2 = new Font("Eras Medium ITC", Font.BOLD, 15);

        Controller event = new Controller(this);

        // label
        panelBrand = new JPanel();
        label = new JLabel("CASIO", JLabel.RIGHT);
        label.setFont(f);
        label.setBounds(250, 10, 100, 30);
        panelBrand.add(label);

        // Sreen
        txtSreen = new JTextField();
        txtSreen.setSize(300, 100);
        txtSreen.setFont(f);
        txtSreen.setEnabled(false);
        txtSreen.setHorizontalAlignment(JTextField.RIGHT);

        // button
        btn1 = new JButton("1");

        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btndivison = new JButton("/");
        btnSqrt = new JButton("sqrt");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btnmulti = new JButton("*");
        btnPercent = new JButton("%");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnsub = new JButton("-");
        btn1diX = new JButton("1/x");
        btn0 = new JButton("0");
        btnaddandsub = new JButton("+/-");
        btnC = new JButton("C");
        btnadd = new JButton("+");
        btnresult = new JButton("=");
        btnOn = new JButton("ON");
        btnOn.setFont(f2);
        btnOff = new JButton("OFF");
        btnOff.setFont(f2);
        btnx2 = new JButton("x2");
        btnAC = new JButton("AC");
        btnDelete = new JButton("<--");

        // ad event 
        btn1.addActionListener(this);
        btn2.addActionListener(event);
        btn3.addActionListener(event);
        btn4.addActionListener(event);
        btn5.addActionListener(event);
        btn6.addActionListener(event);
        btn7.addActionListener(event);
        btn8.addActionListener(event);
        btn9.addActionListener(event);
        btn0.addActionListener(event);
        btn1diX.addActionListener(event);
        btnadd.addActionListener(event);
        btnsub.addActionListener(event);
        btndivison.addActionListener(event);
        btnmulti.addActionListener(event);
        btnPercent.addActionListener(event);
        btnresult.addActionListener(event);
        btnC.addActionListener(event);
        btnSqrt.addActionListener(event);
        btnaddandsub.addActionListener(event);
        btnDelete.addActionListener(event);
        btnAC.addActionListener(event);
        btnx2.addActionListener(event);
        btnOn.addActionListener(event);
        btnOff.addActionListener(event);

        // add panel
        panelCalculator = new JPanel();
        panelCalculator.setLayout(new GridLayout(5, 5));
        panelCalculator.add(btn1);
        panelCalculator.add(btn2);
        panelCalculator.add(btn3);
        panelCalculator.add(btndivison);
        panelCalculator.add(btnSqrt);
        panelCalculator.add(btn4);
        panelCalculator.add(btn5);
        panelCalculator.add(btn6);
        panelCalculator.add(btnmulti);
        panelCalculator.add(btnPercent);
        panelCalculator.add(btn7);
        panelCalculator.add(btn8);
        panelCalculator.add(btn9);
        panelCalculator.add(btnsub);
        panelCalculator.add(btn1diX);
        panelCalculator.add(btn0);
        panelCalculator.add(btnaddandsub);
        panelCalculator.add(btnC);
        panelCalculator.add(btnadd);
        panelCalculator.add(btnresult);
        panelCalculator.add(btnOn);
        panelCalculator.add(btnOff);
        panelCalculator.add(btnx2);
        panelCalculator.add(btnAC);
        panelCalculator.add(btnDelete);

        // pannel center
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.add(txtSreen, BorderLayout.NORTH);
        panelCenter.add(panelCalculator, BorderLayout.CENTER);

        // panel Frame
        this.add(panelBrand, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);

    }

    // ghi so len man hinh
    public void WriteNumber(JButton number) {
        if (blank) {
            blank = false;
            txtSreen.setText("");
        }
        String gt = txtSreen.getText();
        if (gt.length() < 12) {
            if (gt.equals("0")) {
                gt = "";
            }
            long so = Long.parseLong(gt + number.getText());
            txtSreen.setText(String.valueOf(so));
        }
    }

    // nhan phep toan
    public void phepToan(JButton a) {
        pheptinh = a.getText();
        toanTu1 = txtSreen.getText();
        txtSreen.setText("");

    }

    // ket qua
    public void Result() {
        if (txtSreen.getText().isEmpty() || toanTu1.isEmpty()) {
            return;
        } else {
            double a = Double.parseDouble(toanTu1);
            double b = Double.parseDouble(txtSreen.getText());

            double result = 0;
            if (pheptinh.equals("+")) {
                result = a + b;
            } else if (pheptinh.equals("-")) {
                result = a - b;
            } else if (pheptinh.equals("*")) {
                result = a * b;
            } else if (pheptinh.equals("/")) {
                result = a / b;
            } else if (pheptinh.equals("x2")) {
                result = Math.pow(a, b);
            }
            txtSreen.setText(String.valueOf(result));
        }
        blank = true;

    }

    // thay doi dau cong thanh tru
    public void changeAddtosub() {

        if (txtSreen.getText().isEmpty()) {
            return;
        }
        double value = Double.parseDouble(txtSreen.getText());
        value = -value;
        txtSreen.setText("" + value);

    }

    // can bac 2
    public void Sqrt() {
        if (txtSreen.getText().isEmpty()) {
            return;
        } else {
            double result = Math.sqrt(Double.parseDouble(txtSreen.getText()));
            txtSreen.setText(String.valueOf(result));
        }
        blank = true;
    }
    // lay phan tram

    public void ActivePercent() {
        if (txtSreen.getText().isEmpty()) {
            return;
        } else {

            double result = Double.parseDouble(txtSreen.getText()) / 100;
            txtSreen.setText(String.valueOf(result));
        }
        blank = true;
    }

    // 1 chai voi ket qua
    public void chiaChinhNo() {
        if (txtSreen.getText().isEmpty()) {
            return;
        } else {
            double result = 1 / Double.parseDouble(txtSreen.getText());
            txtSreen.setText(String.valueOf(result));
        }
        blank = true;
    }

    public void Reset() {
        toanTu1 = "";
        txtSreen.setText("");
        blank = false;
    }

    public void Delete() {
        if (txtSreen.getText().length() > 0) {
            int a = txtSreen.getText().length();
            int b = txtSreen.getText().length() - 1;
            StringBuilder str = new StringBuilder(txtSreen.getText());
            str.deleteCharAt(b);
            txtSreen.setText(str.toString());
        }

    }

    @SuppressWarnings("empty-statement")
    public void On() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);;
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn0.setEnabled(true);
        btn1diX.setEnabled(true);
        btnadd.setEnabled(true);
        btnsub.setEnabled(true);
        btndivison.setEnabled(true);
        btnmulti.setEnabled(true);
        btnPercent.setEnabled(true);
        btnresult.setEnabled(true);
        btnC.setEnabled(true);
        btnSqrt.setEnabled(true);
        btnaddandsub.setEnabled(true);
        btnDelete.setEnabled(true);
        btnAC.setEnabled(true);
        btnx2.setEnabled(true);
    }

    @SuppressWarnings("empty-statement")
    public void off() {
        Reset();
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);;
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn0.setEnabled(false);
        btn1diX.setEnabled(false);
        btnadd.setEnabled(false);
        btnsub.setEnabled(false);
        btndivison.setEnabled(false);
        btnmulti.setEnabled(false);
        btnPercent.setEnabled(false);
        btnresult.setEnabled(false);
        btnC.setEnabled(false);
        btnSqrt.setEnabled(false);
        btnaddandsub.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAC.setEnabled(false);
        btnx2.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        if (a.matches("^\\d$")) {
            txtSreen.setText(txtSreen.getText() + a);
        }
    }

}
