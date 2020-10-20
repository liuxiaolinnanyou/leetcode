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
        int[] arr1 = {80, 0, 5, 0, 0, 0, 134, 0, 3, 6, 5, 0, 7, 0};
        int[] arr2 = {1, 2, 0, 0, 0, 0, 0, 3, 0, 0, 4, 5, 0, 0, 6, 7};
        int[] arr3 = {1, 2, 0, 0, 0, 0, 0, 3, 0, 0, 4, 5, 0, 0, 6, 7};
        System.out.println(Arrays.toString(arr1));
        solution(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("------------------");

//        System.out.println(Arrays.toString(arr2));
//        solution1(arr2);
//        System.out.println(Arrays.toString(arr2));
//        System.out.println("------------------");

        System.out.println(Arrays.toString(arr3));
        solution2(arr3);
        System.out.println(Arrays.toString(arr3));
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

    // 将所有的 0 移至数组的末尾    (代码有问题，不能解决有连续 0 的问题)
    public static void solution1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int m = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                int j = i;
                while (j < m) {
                    arr[j] = arr[j + 1];
                    j++;
                }
                m = j - 1;
                arr[j] = temp;
            }
        }
    }

    public static void solution2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int k = 0;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k++;
            }
        }
    }
}