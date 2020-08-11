package 九轮;

import java.util.Arrays;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 。
 */
public class 对角线遍历 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(arr)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        // 考虑边界 []
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        // m行 n列
        int m = matrix.length;
        int n = matrix[0].length;
        // 用来记录加入到结果数组的元素的下标
        int count = 0;
        // 用来保存结果的数组 大小为矩阵的元素个数
        int[] result = new int[m * n];
        for (int i = 0; i < m + n - 1; i++) {
            // i为0或偶数时 沿对角线向上遍历
            if (i == 0 || i % 2 == 0) {
                // 发现规律x+y = i 然后找边界（x坐标超过主对角线时的情况）
                int x = i < m ? i : m - 1;
                int y = i - x;
                // 开始遍历 x坐标不断减 y坐标不断加 当x减到0 或者 y加到列n的值
                while (x >= 0 && y < n) {
                    result[count] = matrix[x][y];
                    x--;
                    y++;
                    count++;
                }
            } else {
                // 沿对角线向下遍历
                int y = i < n ? i : n - 1;
                int x = i - y;
                // y坐标不断减 x坐标不断加 当y减到0 或者 x加到行m的值
                while (y >= 0 && x < m) {
                    result[count] = matrix[x][y];
                    y--;
                    x++;
                    count++;
                }
            }
        }
        return result;
    }
}
