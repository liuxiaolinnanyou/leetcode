package 达西;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * <p>
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * <p>
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 */
public class 二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        int[][] arr1 = {{0, 1}, {1, 0}};
        int[][] arr2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(arr1));
        System.out.println(shortestPathBinaryMatrix(arr2));
    }


    private static int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private static int row, col;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Queue<int[]> pos = new LinkedList<>();  // 用队列存储每一个访问的节点
        grid[0][0] = 1;                         // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        pos.add(new int[]{0, 0});               // 添加原点
        while (!pos.isEmpty() && grid[row - 1][col - 1] == 0) { // 求最短路径 使用 BFS
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]];                 // 当前点的路径长度
            for (int i = 0; i < 8; i++) {                       // 8个方向
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1;           // 下一个点的路径长度要 + 1
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];   // 如果最后终点的值还是 0，说明没有到达
    }

    private static boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
