package vivo_2020;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 */
public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(2, 3));
        System.out.println("--------------------");
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 7));
    }

    // 通过   自己写的
    public static int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;    // 只有一条路径
        }
        int[][] dp = new int[n][m];
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != 0) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}