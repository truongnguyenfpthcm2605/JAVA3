/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package functioninterfacetion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 *
 * @author truong
 */
@FunctionalInterface
interface funt {

    void ma(String a, String c);
}

public class FunctionInterfacetion {

    public static void main(String[] args) {
//        funt f = (a,b)->{
//            System.out.println(a + b);
//        };
//        f.ma("Truong", "Nguyen");
//        List<Integer> Hello = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Hello.add(i);
//        }
//        Hello.forEach((e)->{
//            System.out.println(e);
//        });
//        Collections.reverse(Hello);
//        Hello.forEach((e)->{
//            System.out.println(e);
//        });

        int[] a = {19, -2, 13, 41, 5};
        // tinh toong Instream
        int c = IntStream.of(a).sum();
        // maxx
        int max = IntStream.of(a).max().getAsInt();
        // min
        int min = IntStream.of(a).min().getAsInt();
        // avg
        double avg = IntStream.of(a).average().getAsDouble();
        // diem so chan
        long chan = IntStream.of(a).filter(n -> n % 2 == 0).count();
        // sap xep tang 
        System.out.println("Sap Xep Tang");
        IntStream.of(a).sorted().forEach((n -> System.out.println(n)));
        System.out.println("Sap Xep Gian");

        System.out.println("tong" + c);
        System.out.println("Lon nhat" + max);
        System.out.println("Nho nhat " + min);
        System.out.println("trung binh" + avg);
        System.out.println("Tong cac so chan " + chan);
        System.out.println("Lay ra danh sach so chan");
        // la ra ca so le trong mang
        IntStream.of(a).filter(n -> n % 2 != 0).forEach(n -> System.out.println(n));
        System.out.println("In ra cac phan tu");
        IntStream.of(a).forEach(n -> System.out.println(n));
        // cap nhat 1 mang khac bang Map
        IntStream.of(a).map(n -> n + 1).forEach(n -> System.out.println(n));
        int x = IntStream.of(a).reduce(0,
                (element1, element2) -> element1 + element2);
        System.out.println(x);

    }

}
