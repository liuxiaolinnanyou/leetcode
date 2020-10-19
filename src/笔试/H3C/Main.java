package 笔试.H3C;

import java.util.Arrays;

/**
 * 输入一个字符串，包含6个数字，中间用空格区分，每个数字的取值范围在0-9之间，计算组成的所有不重复的三位数(大于等于100)
 * 最大值与最小值的差，异常时输出-1
 * <p>
 * 输入："1 0 3 5 2 7"
 * 输出：651
 */
// AC 40
public class Main {
    public static void main(String[] args) {
        String s = "1 0 3 5 2 7";
        System.out.println(sub(s));
    }

    public static int sub(String input) {
        // write code here
        String[] split = input.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        boolean flag = false;
        if (arr[0] == 0) {
            flag = true;
        }
        if (flag) {
            int max = arr[arr.length - 1] * 100 + arr[arr.length - 2] * 10 + arr[arr.length - 3];
            int min = arr[1] * 100 + arr[2];
            return max - min;
        } else {
            int max = arr[arr.length - 1] * 100 + arr[arr.length - 2] * 10 + arr[arr.length - 3];
            int min = arr[0] * 100 + arr[1] * 10 + arr[2];
            return max - min;
        }
    }
}