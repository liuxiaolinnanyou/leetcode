package sort_排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class 按奇偶排序数组 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

    // 菜鸡做法
    public static int[] sortArrayByParity(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int[] b = new int[arr.length];
        for (int i = 0; i < b.length; i += 2) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) % 2 == 0) {
                    b[i] = list.get(j);
                    list.remove(j);
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < b.length; i += 2) {    // 剩下的全是奇数
            b[i] = list.get(count++);
        }
        return b;
    }

    // 将原来数组中的奇数和偶数分别存放在两个数组或者list中，然后在轮流放到结果数组里(自己写)
    // 遍历两次原来的数组，偶数存放到结果数组中的偶数位置，奇数存放到结果数组中的奇数位置。
    public static int[] sortArrayByParity2(int[] arr) {
        int[] res = new int[arr.length];
        int i = 0;
        for (int x : arr) {     // 第一次遍历找出所有偶数
            if (x % 2 == 0) {
                res[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : arr) {     // 第二次遍历找出所有奇数
            if (x % 2 != 0) {
                res[i] = x;
                i += 2;
            }
        }
        return res;
    }

    // 不开辟额外的空间
    public static int[] sortArrayByParity3(int[] arr) {
        int j = 1;
        for (int i = 0; i < arr.length; i += 2) {    // 遍历偶数位置的元素
            if (arr[i] % 2 == 1) {                   // 偶数位上的奇数
                while (arr[j] % 2 == 1) {            // 找出所有奇数位的偶数
                    j += 2;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
}
