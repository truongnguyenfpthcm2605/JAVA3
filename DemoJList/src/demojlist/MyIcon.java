/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demojlist;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author truong
 */
public class MyIcon extends JFrame {

    public MyIcon(String title) throws HeadlessException {
        super(title);
        this.setLocationRelativeTo(null);

        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        this.setSize(500, 500);
        ImageIcon icon = new ImageIcon("D:\\JAVA3\\ICON\\search-icon.png");
        JLabel label = new JLabel("Search", icon, JLabel.CENTER);
         ImageIcon iconAdd = new ImageIcon("D:\\JAVA3\\ICON\\new-file-icon.png");
         JLabel lblDiachi = new JLabel(iconAdd);
        this.add(label);
        this.add(lblDiachi);
    }

    public static void main(String[] args) {
        new MyIcon("d").setVisible(true);
    }

}
