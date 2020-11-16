package 动态规划;

/**
 * 在二维网格 grid 上，有 4 种类型的方格：
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * <p>
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 * <p>
 * 输入1：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出1：2
 * 解释：
 * 我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * <p>
 * <p>
 * 输入2：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出2：4
 * 解释：
 * 我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * <p>
 * <p>
 * 输入3：[[0,1],[2,0]]
 * 输出3：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 */
public class 不同路径3 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][] arr2 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        int[][] arr3 = {{0, 1}, {2, 0}};
        System.out.println(uniquePathsIII(arr1));
        System.out.println(uniquePathsIII(arr2));
        System.out.println(uniquePathsIII(arr3));
    }

    // dfs + 回溯
    // dfs最基础的应用是寻找迷宫是否能走出
    // 这里多了几个约束条件：
    //
    // 起始位置，终止位置不确定
    // 每一个无障碍方格都要通过一次
    // 求不同路径的数目
    // 分别对上述约束条件进行分析：
    //
    // 先遍历二维数组，找到起始位置，将终止位置作为 dfs 的结束标志
    // 设定一个最大步长，并先遍历二维数组，统计最大步长的数值，即 0 的个数 + 1(当到达终止位置时，grid[i][j] == 2，也算步长 + 1)
    // 加入回溯的思想，在每次对当前位置dfs后(标记grid[y][x] = -1，下次不能走了)，将此位置重置回grid[y][x] = 0
    public static int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, stepNum = 1;  // 当grid[i][j] == 2, stepNum++, 这里直接初始化为1
        // 遍历获取起始位置和统计总步数
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startY = i;
                    startX = j;
                    continue;
                }
                if (grid[i][j] == 0) {
                    stepNum++;
                }
            }
        }
        // 深度优先搜索
        return dfs(startX, startY, stepNum, grid);
    }

    // 深度优先搜索
    private static int dfs(int x, int y, int stepNum, int[][] grid) {
        // 排除越界的情况 和 遇到障碍的情况
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return stepNum == 0 ? 1 : 0;
        }
        grid[x][y] = -1;  // 已走过的标记为障碍
        int res = 0;
        res += dfs(x - 1, y, stepNum - 1, grid);
        res += dfs(x + 1, y, stepNum - 1, grid);
        res += dfs(x, y - 1, stepNum - 1, grid);
        res += dfs(x, y + 1, stepNum - 1, grid);
        grid[x][y] = 0;  // dfs遍历完该位置为起始位置的情况后，置零，以不影响后面的dfs
        return res;
    }
}