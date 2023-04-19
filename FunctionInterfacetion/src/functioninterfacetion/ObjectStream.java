/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functioninterfacetion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 *
 * @author truong
 */
public class ObjectStream {

    private String name;
    private double mark;

    public ObjectStream() {
    }

    public ObjectStream(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public static void main(String[] args) {
        ObjectStream sv = new ObjectStream();
        List<ObjectStream> list = new ArrayList<>();
        list.add(new ObjectStream("Truong", 10));
        list.add(new ObjectStream("Cuong", 9));
        list.add(new ObjectStream("Hau", 8));
        list.add(new ObjectStream("Thien", 7));
        list.add(new ObjectStream("Tuan", 5));
        // tinh diem trung binh cau tat ca sinh vien
        double avg =list.stream().flatMapToDouble(n -> DoubleStream.of(n.getMark())).average().getAsDouble();
        System.out.println("Diem trung binh cua tat ca sinh vien : " + avg);
        
        // dong lap Stream
        list.stream().forEach((n)->{
            System.out.println(n.getName());
            System.out.println(n.getMark());
        });
        // lay ra nhung sinh vien co diem lon hon 5
        list.stream().filter(n -> n.getMark()>5).forEach(n->{
            System.out.println(n.getName());
            System.out.println(n.getMark());
        });
        // diem sinh vien
        long countSv = list.stream().count();
        System.out.println(countSv);

        

    

    }

}
