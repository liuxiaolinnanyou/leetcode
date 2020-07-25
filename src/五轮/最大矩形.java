package 五轮;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 输入：
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出：6
 */
public class 最大矩形 {
    public static void main(String[] args) {

    }

    // 思路是 先算出每个节点的1xn的矩形,也可以理解为垂直高度,这个高度其实就是从上到下连续多少个1
    // 有了这个高度之后 我们会发现一个规律
    // 当前的这个在这个节点 分别 往左和往右寻找连续的比自己大或者相等的1xn矩形
    // 直到找到比自己矮的1xn矩阵
    // 这里左边加右边连续比自己高的矩阵个数 再加上自己 乘以自己的高度
    // 这样就得到了以当前节点的高度 的矩形的最大面积
    // 遍历整个矩阵即可得到最大矩阵
    public static int maximalRectangle(char[][] matrix) {
        int x = matrix.length;
        if (x == 0) {
            return 0;
        }
        int y = matrix[0].length;
        int max = 0;

        // 用grid记录每个节点1xn矩阵的面积 这个面积其实也是高度
        int[][] grid = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == '1') {
                    grid[i][j] = grid[i > 0 ? i - 1 : 0][j] + matrix[i][j] - '0';
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] > 0) {
                    // l r 用于记录左右连续高于自己的1xn矩阵的个数
                    int l = 0, r = 0;
                    // 向左寻找小于当前高度
                    for (int k = j - 1; k >= 0; k--) {
                        if (grid[i][k] < grid[i][j]) break;
                        l++;
                    }
                    // 向右寻找小于当前高度
                    for (int u = j + 1; u < y; u++) {
                        if (grid[i][u] < grid[i][j]) break;
                        r++;
                    }
                    max = Math.max(max, (l + r + 1) * grid[i][j]);
                }
            }
        }
        return max;
    }
}