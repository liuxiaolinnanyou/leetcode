package 笔试.老虎集团;

import java.util.ArrayList;

// 原题
public class Main {
    public static void main(String[] args) {

    }

    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            if ((Math.abs(array[i]) % 2) != 0) {
                int tmp = array[i];
                int j = i;
                while (j > m) {
                    array[j] = array[j - 1];
                    j--;
                }
                m = j + 1;
                array[j] = tmp;
            }
        }
        return array;
    }
}
