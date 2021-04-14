package 数组;

/**
 * 给定数组a=[3,4,5,6,5,6,7,8,9,8],这个数组中相邻元素之差都为1，给定数字9，它在数组中第一次出现的位置的下标为8。
 */
public class 指定数字在数组中第一次出现的位置 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
        System.out.println(findIndex2(arr, 9));
        System.out.println(findIndex2(arr, 5));
        System.out.println(findIndex2(arr, 27));
    }

    // 暴力法
    public static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 方法 2
    public static int findIndex2(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == target) {
                return i;
            } else {
                i += Math.abs(target - arr[i]);
            }
        }
        return -1;
    }
}