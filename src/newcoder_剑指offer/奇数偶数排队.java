package newcoder_剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class 奇数偶数排队 {
    public static void main(String[] args) {
        int[] arr = {12, 45, 15, 12, 16, 13, 13, 13, 17, 14, 18};
//        System.out.println(reOrderArray(arr));
        // 没有返回值  不能使用输出调用
//        System.out.println(3&1);
//        System.out.println(6&1);
//        System.out.println(4&1);
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
//        printArray(arr);
        System.out.println("排序后：");
        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
//        printArray(arr);
    }

    // 方法 1    不借助额外的空间
    public static void reOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((Math.abs(arr[i]) % 2) != 0) {     // 奇数    (Math.abs(arr[i])&1) != 0
                int tmp = arr[i];
                int j = i;
                while (j > m) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                m = j + 1;
                arr[j] = tmp;
            }
        }
    }


    // 方法 2
    public static void reOrderArray2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 先用集合保存偶数元素
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                list.add(arr[i]);
            }
        }
        // 奇数元素存到前半部分
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                arr[count++] = arr[i];
            }
        }
        // 处理偶数元素
        for (int i : list) {
            arr[count++] = i;
        }
    }


//    // 打印数组
//    public static void printArray(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                System.out.print(arr[i]);
//            } else {
//                System.out.print(arr[i] + ", ");
//            }
//        }
//        System.out.println("]");
//    }
}