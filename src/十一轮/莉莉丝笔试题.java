package 十一轮;

import java.util.Arrays;

/**
 * 给定一个数组，在不开辟新的内存空间的情况下将其中所有的 0 移动至数组开头。
 * <p>
 * 输入：[80,0,5,0,134,0,3,6,5,0,7,0]
 * 输出：[0,0,0,0,0,80,5,134,3,6,5,7]
 */
public class 莉莉丝笔试题 {
    public static void main(String[] args) {
        int[] arr = {80, 0, 5, 0, 134, 0, 3, 6, 5, 0, 7, 0};
        System.out.println(Arrays.toString(arr));
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                int j = i;
                while (j > m) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                m = j + 1;
                arr[j] = temp;
            }
        }
    }
}