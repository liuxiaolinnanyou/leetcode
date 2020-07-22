package 一轮;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class 最小路径和 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(arr));
    }

    // 暴力法
    // 对于每个元素我们考虑两条路径，向右走和向下走，在这两条路径中挑选路径权值和较小的一个。
    // cost(i,j)=grid[i][j]+min(cost(i+1,j),cost(i,j+1))
    public static int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    private static int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }


    // 动态规划
    // 我们新建一个额外的 dp 数组，与原矩阵大小相同。在这个矩阵中，dp(i, j) 表示从坐标 (i, j) 到右下角的最小路径权值。
    // 我们初始化右下角的 dp 值为对应的原矩阵值，然后去填整个矩阵，对于每个元素考虑移动到右边或者下面，
    // 因此获得最小路径和我们有如下递推公式
    // dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
    public static int minPathSum2(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[0].length - 1; j >= 0; j--) {
//                if (i == grid.length - 1 && j != grid[0].length - 1)
//                    dp[i][j] = grid[i][j] + dp[i][j + 1];
//                else if (j == grid[0].length - 1 && i != grid.length - 1)
//                    dp[i][j] = grid[i][j] + dp[i + 1][j];
//                else if (j != grid[0].length - 1 && i != grid.length - 1)
//                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//                else
//                    dp[i][j] = grid[i][j];
//            }
//        }
//        return dp[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}