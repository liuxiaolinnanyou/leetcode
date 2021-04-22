package 十四轮;

// 力扣 363

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * 说明：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 */
public class 矩阵区域不超过K的最大数值和 {
    public static void main(String[] args) {

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) {          // 枚举左边界
            int[] rowSum = new int[rows];         // 左边界改变才算区域的重新开始
            for (int r = l; r < cols; r++) {      // 枚举右边界
                for (int i = 0; i < rows; i++) {  // 按每一行累计到 dp
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) {    // 尽量提前
                    return k;
                }
            }
        }
        return max;
    }

    // 在数组 arr 中，求不超过 k 的最大值
    public static int dpmax(int[] arr, int k) {
        int rollSum = arr[0];
        int rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) {
                rollSum += arr[i];
            } else {
                rollSum = arr[i];
            }
            if (rollSum > rollMax) {
                rollMax = rollSum;
            }
        }
        if (rollMax <= k) {
            return rollMax;
        }
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k) {    // 尽量提前
                    return k;
                }
            }
        }
        return max;
    }
}