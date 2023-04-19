/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.HashMap;
import java.util.Set;

 /*
    TreeMap y chang HashMap
    LinkedhaspMap cung y chang
*/
public class MyMap {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // add element
        map.put("Nguyen Van A", 1);
        map.put("Nguyen Van B", 2);
        map.put("Nguyen Van C", 3);
        map.put("Nguyen Van D", 4);
        map.forEach((Key, Value) -> {
            System.out.println(Value);
        });
        // add Object Student
        HashMap<Integer, Student> studentList = new HashMap<>();
        Student sv = new Student(1, "Nguyen Van Truong");
        studentList.put(sv.getId(), sv);
        Student sv1 = new Student(2, "Nguyen Van Nam");
        studentList.put(sv1.getId(), sv1);
        // lay ra 1 sinh vien
        Student svResult = studentList.get(1);
        // lay key 
        // lay ra tat ca key ton tai trong map dó
        Set<Integer> set = studentList.keySet();
        set.forEach((item)-> {
            System.out.println(item +"" + studentList.get(item));
        });
        for (Integer integer : set) {
            System.out.println(integer + "" + studentList.get(integer));
        }
        
        // ham kiem tra co ton tai
        System.out.println(studentList.containsKey(3));
        
        
    }
}
