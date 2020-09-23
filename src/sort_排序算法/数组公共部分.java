package sort_排序算法;

import java.util.Arrays;

/**
 * 输入两个有序整型数组，输出两个数组的公共部分，公共部分要求为有序数组，实现最快算法。
 * <p>
 * 输入：[-5,0,6,8,9,10],[0,8,9,11,15]
 * 输出：[0,8,9]
 */
public class 数组公共部分 {
    public static void main(String[] args) {
        int[] num1 = {-5, 0, 6, 8, 9, 10};
        int[] num2 = {0, 8, 9, 11, 15};
        System.out.println(Arrays.toString(solution(num1, num2)));
    }

    public static int[] solution(int[] num1, int[] num2) {
        int num = Math.min(num1.length, num2.length);
        int[] res = new int[num];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            } else if (num1[i] > num2[j]) {
                j++;
            } else {
                res[index++] = num1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}