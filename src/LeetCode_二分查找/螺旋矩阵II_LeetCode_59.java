package LeetCode_二分查找;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class 螺旋矩阵II_LeetCode_59 {
    // 和 F:\IdeaProjects\leetcode\src\newcoder_剑指offer\顺时针顺序打印矩阵.java 比较
    // 循环不变量
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++;
            }// left to right.
            t++;
            for (int i = t; i <= b; i++) {
                mat[i][r] = num++;
            }// top to bottom.
            r--;
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++;
            } // right to left.
            b--;
            for (int i = b; i >= t; i--) {
                mat[i][l] = num++;
            }// bottom to top.
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}