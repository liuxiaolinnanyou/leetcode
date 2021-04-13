package Test;

/**
 * 思考：
 * 如果使用三维数组来进行比较排序，Comparator中的泛型是一个二维数组，这时候应该怎么写？
 */

import java.util.Arrays;
import java.util.Comparator;

public class StringArrayTest3 {
    public static void main(String[] args) {
        String[][] arr = {
                {"Apple", "1", "80"},
                {"Apple", "2", "62"},
                {"Apple", "4", "73"},
                {"Orange", "4", "65"},
                {"Orange", "1", "90"},
                {"Apple", "3", "91"},
                {"Orange", "3", "88"},
                {"Orange", "5", "90"}
        };

        String[][][] arr1 = {
                {{"Apple", "1", "80"}},
                {{"Apple", "2", "62"}},
                {{"Apple", "4", "73"}},
                {{"Orange", "4", "65"}},
                {{"Orange", "1", "90"}},
                {{"Apple", "3", "91"}},
                {{"Orange", "3", "88"}},
                {{"Orange", "5", "90"}}
        };

        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }

        System.out.println("---------------------------------------------");
        // 排序
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int num1 = o1[0].compareTo(o2[0]);
                int num2 = num1 == 0 ? Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]) : num1;
                int num3 = num2 == 0 ? Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]) : num2;
                return num3;
            }
        });

        for (String[] str : arr) {
            System.out.println(Arrays.toString(str));
        }
    }
}