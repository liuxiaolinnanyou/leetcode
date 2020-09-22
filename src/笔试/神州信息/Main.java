package 笔试.神州信息;

/**
 * 度度熊有一个N个数的数组，他想将数组从小到大排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 * <p>
 * 输入："19 5 9 255"
 * 输出：2
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(sort("19 5 9 255"));
        System.out.println(sort("15 4 6 8 23 2"));
    }

    public static int sort(String inData) {
        // write code here
        String[] split = inData.split(" ");
        int[] arr = new int[split.length];
        int[] sort = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            sort[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(sort);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sort[count]) {
                count++;
                if (count == arr.length) {
                    break;
                }
            }
        }
        return arr.length - count;
    }
}