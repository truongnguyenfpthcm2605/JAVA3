/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author truong
 */
public class Controller implements ActionListener {

    bai2 view;

    public Controller(bai2 view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "1" -> this.view.WriteNumber(this.view.btn1);
            case "2" -> this.view.WriteNumber(this.view.btn2);
            case "3" -> this.view.WriteNumber(this.view.btn3);
            case "4" -> this.view.WriteNumber(this.view.btn4);
            case "5" -> this.view.WriteNumber(this.view.btn5);
            case "6" -> this.view.WriteNumber(this.view.btn6);
            case "7" -> this.view.WriteNumber(this.view.btn7);
            case "8" -> this.view.WriteNumber(this.view.btn8);
            case "9" -> this.view.WriteNumber(this.view.btn9);
            case "0" -> this.view.WriteNumber(this.view.btn0);
            case "+" -> this.view.phepToan(this.view.btnadd);
            case "-" -> this.view.phepToan(this.view.btnsub);
            case "*" -> this.view.phepToan(this.view.btnmulti);
            case "/" -> this.view.phepToan(this.view.btndivison);
            case "+/-" -> this.view.changeAddtosub();
            case "sqrt" -> this.view.Sqrt();
            case "%" -> this.view.ActivePercent();
            case "1/x" -> this.view.chiaChinhNo();
            case "=" -> this.view.Result();
            case "C" -> this.view.Reset();
            case "ON" -> this.view.On();
             case "OFF" -> this.view.off();
             case "<--" -> this.view.Delete();
             case "x2" -> this.view.phepToan(this.view.btnx2);
             case "AC" -> this.view.Reset();
             
            default -> throw new AssertionError();
        }
    }

}
