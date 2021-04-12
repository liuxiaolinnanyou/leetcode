package Test;

// 测试荣耀的笔试题

import java.util.Arrays;

public class StringArrayTest2 {
    public static void main(String[] args) {
        String[][] arr = {
                {"Apple", "62"},
                {"Apple", "73"},
                {"Orange", "65"},
                {"Orange", "90"},
                {"Apple", "91"},
                {"Orange", "88"},
                {"Orange", "90"},
                {"Apple", "100"}
        };

        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }

        System.out.println("----------------------------");

        // 注意比较两者的区别
//        Arrays.sort(arr, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        Arrays.sort(arr, (o1, o2) -> o1[0].equals(o2[0]) ? Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]) : o1[0].compareTo(o2[0]));
        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }
    }
}