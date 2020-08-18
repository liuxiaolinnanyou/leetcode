package 笔试.用友;

import java.util.Arrays;

/**
 * 实现
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * <p>
 * [
 * [7,8,9],
 * [4,5,6],
 * [1,2,3]
 * ]
 */
public class Main1 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(convert(arr)));
    }

    public static int[][] convert(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int[] arr : matrix) {
            res[m - 1] = arr;
            m--;
        }
        return res;
    }
}