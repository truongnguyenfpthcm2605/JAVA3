/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.Stack;

/**
 *
 * @author truong
 */
public class MyStack {
    // add phan tu vo vd 1,2,3
    // khi lay ra 3,2,1
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.forEach((item) -> {
            System.out.println(item);
        });
    }
}
