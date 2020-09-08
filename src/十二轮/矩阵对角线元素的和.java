package 十二轮;

/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * <p>
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出：8
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * 提示：
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class 矩阵对角线元素的和 {
    public static void main(String[] args) {

    }

    // 自己写的
    public static int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        if (len % 2 == 0) {
            for (int i = 0; i < len; i++) {
                sum += mat[i][i];
                sum += mat[i][len - 1 - i];
            }
        } else {
            for (int i = 0; i < len; i++) {
                sum += mat[i][i];
                sum += mat[i][len - 1 - i];
            }
            sum -= mat[len / 2][len / 2];
        }
        return sum;
    }

    public static int diagonalSum2(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 - i) {
                sum += mat[i][i];
            } else {
                sum += mat[i][i] + mat[i][len - 1 - i];
            }
        }
        return sum;
    }
}