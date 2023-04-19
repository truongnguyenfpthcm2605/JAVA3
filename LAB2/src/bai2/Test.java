/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import BAI1.view;
import javax.swing.UIManager;

/**
 *
 * @author truong
 */
public class Test {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            new bai2("Calculator").setVisible(true);
        } catch (Exception e) {
        }
    }
}
