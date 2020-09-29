package 笔试.建信金融科技;

/**
 * 二维数组查找第 k 小的元素。
 * 输入：
 * [
 * [1,5,9],
 * [10,11,13],
 * [12,13,15]
 * ]
 * k = 8
 * <p>
 * 输出：
 * 13
 */
public class 二维排序数组中的第k小元素 {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] arr1 = {{1, 3, 6}, {2, 4, 7}, {5, 8, 9}};
        System.out.println(kthSmallest(arr, 8));
        System.out.println("--------------------");
        System.out.println(kthSmallest(arr1, 8));
    }

    public static int kthSmallest(int[][] matrix, int m) {
        // write code here
        int n = matrix.length - 1;
        int left = matrix[0][0];
        int right = matrix[n][n];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkNum(n, m, mid, matrix)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean checkNum(int n, int m, int mid, int[][] matrix) {
        int row = 0;
        int col = n;
        int num = 0;
        while (row <= n && col >= 0) {
            if (matrix[row][col] <= mid) {
                num += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return num >= m;
    }
}