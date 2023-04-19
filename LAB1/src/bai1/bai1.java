/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author truong
 */
public class bai1 extends JFrame {

    JLabel label1, label2;
    JPanel contriPanel;
    JCheckBox chkApple, chkMango, chkPeer;

    public bai1(String title) throws HeadlessException {
        super(title);
        innit();
        Action();
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setLocationRelativeTo(null);
          
    }

    public void innit() {
        int width = 400;
        int height = 200;
        this.setSize(width, height);
        this.setLayout(new GridLayout(3, 1));

        label1 = new JLabel("Contril in action: CheckBox", JLabel.CENTER);
        label2 = new JLabel("Apple CheckBox : checked", JLabel.CENTER);
        label2.setSize(350, 100);
        contriPanel = new JPanel(new FlowLayout());

        this.add(label1);
        this.add(contriPanel);
        this.add(label2);

    }

    public void Action() {
        chkApple = new JCheckBox("Apple");
        chkMango = new JCheckBox("Mango");
        chkPeer = new JCheckBox("Peer");
        chkApple.setMnemonic(KeyEvent.VK_C);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);

        chkApple.addItemListener((ItemEvent e) -> {
            label2.setText("Apple Checkbox : " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
        });
        chkMango.addItemListener(((e) -> {
            label2.setText("Mango Checkbox : " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
        }));
        chkPeer.addItemListener(((e) -> {
            label2.setText("Peer Checkbox : " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
        }));
        contriPanel.add(chkApple);
        contriPanel.add(chkMango);
        contriPanel.add(chkPeer);

    }

    public static void main(String[] args) {
        new bai1("Bai 1").setVisible(true);
    }

}
