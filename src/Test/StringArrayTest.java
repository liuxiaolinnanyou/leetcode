package Test;

import java.util.Arrays;

public class StringArrayTest {
    public static void main(String[] args) {
        String[][] arr = {
                {"hello", "world"},
                {"apple", "phone"},
                {"oppo", "phone"},
                {"apple", "car"}
        };

        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }

        System.out.println("------------------------------------------------");
        Arrays.sort(arr, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));

        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }
    }
}