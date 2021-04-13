package Test;

import java.util.Arrays;
import java.util.Comparator;

public class StringArrayTest3 {
    public static void main(String[] args) {
        String[][][] arr = {
                {{"Apple", "1", "80"}},
                {{"Apple", "2", "62"}},
                {{"Apple", "4", "73"}},
                {{"Orange", "4", "65"}},
                {{"Orange", "1", "90"}},
                {{"Apple", "3", "91"}},
                {{"Orange", "3", "88"}},
                {{"Orange", "5", "90"}}
        };

        for (String[][] str : arr) {
            for (String[] strStr : str) {
                System.out.println(Arrays.toString(strStr));
            }
        }

        // 排序
//        Arrays.sort(arr, new Comparator<String[][]>() {
//            @Override
//            public int compare(String[][] o1, String[][] o2) {
//
//            }
//        });
    }
}