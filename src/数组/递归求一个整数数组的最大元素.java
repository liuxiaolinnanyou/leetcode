package 数组;

public class 递归求一个整数数组的最大元素 {
    public static void main(String[] args) {
        int[] num = {0, 16, 2, 3, 4, 5, 10, 7, 8, 9};
        System.out.println(maxnum(num, 0));
    }

    public static int maxnum(int[] arr, int begin) {
        int length = arr.length - begin;
        if (length == 1) {
            return arr[begin];
        } else {
            return max(arr[begin], maxnum(arr, begin + 1));
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
