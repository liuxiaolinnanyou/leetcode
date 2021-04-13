package Test;

import java.util.Arrays;

public class FruitTest {
    public static void main(String[] args) {
        Fruit f1 = new Fruit("Apple", 1, 80);
        Fruit f2 = new Fruit("Apple", 2, 62);
        Fruit f3 = new Fruit("Apple", 4, 73);
        Fruit f4 = new Fruit("Orange", 4, 65);
        Fruit f5 = new Fruit("Orange", 1, 90);
        Fruit f6 = new Fruit("Apple", 3, 91);
        Fruit f7 = new Fruit("Orange", 3, 88);
        Fruit f8 = new Fruit("Orange", 5, 90);

        Fruit[] arr = {f1, f2, f3, f4, f5, f6, f7, f8};
        for (Fruit fruit : arr) {
            System.out.println(fruit);
        }

        System.out.println("----------------------------------------------");
        // 排序
        Arrays.sort(arr);
        for (Fruit fruit : arr) {
            System.out.println(fruit);
        }
    }
}