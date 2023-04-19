/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

 /*
    Vector giông y chang ArrayList nhung nó bi tao thua bo nho
    LinkedList thi no se co tootss do cham khi kiem tra tung phan roi r?c nhau
*/
public class MyArrayList {
    public static void main(String[] args) {
     ArrayList<String> list = new ArrayList<>();
     
     list.add("Hello");
     list.add("I am");
     list.add("My Name");
     list.set(1, "Truong");
     
     // duyet cach 1
        System.out.println("cach1");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // cach 2 
        System.out.println("cach2");
        for (String string : list) {
            System.out.println(string);
        }
        // cach 3 
         System.out.println("cach3");
        list.forEach((item) -> {
            System.out.println(item);
        });
        
        /// cach 4 
         System.out.println("cach4");
        Iterator<String> inter = list.iterator();
        while (inter.hasNext()) {
            String next = inter.next();
            System.out.println(next);
            
        }
        // cach 5
         System.out.println("cach5");
        list.stream().forEach(System.out::println);
        
        //cach 6
         System.out.println("cach6");
         list.parallelStream().forEach(System.out::println);

            
        }

    }

