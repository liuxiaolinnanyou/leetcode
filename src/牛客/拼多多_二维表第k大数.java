package 牛客;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在一块长为n，宽为m的场地上，有n✖m个1✖1的单元格。每个单元格上的数字就是按照从1到n和1到m中的数的乘积。具体如下
 * n = 3, m = 3
 * 1   2   3
 * 2   4   6
 * 3   6   9
 * 给出一个查询的值k，求出按照这个方式列举的的数中第k大的值v。
 * 例如上面的例子里，
 * 从大到小为(9, 6, 6, 4, 3, 3, 2, 2, 1)
 * k = 1, v = 9
 * k = 2, v = 6
 * k = 3, v = 6
 * ...
 * k = 8, v = 2
 * k = 9, v = 1
 * <p>
 * 输入描述：只有一行是3个数n, m, k 表示场地的宽高和需要查询的k。使用空格隔开。
 * 输出描述：给出第k大的数的值。
 * <p>
 * 输入：3 3 4
 * 输出：4
 */
public class 拼多多_二维表第k大数 {
    // 双重for循环   只通过30%
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int k = sc.nextInt();
//        int[][] arr = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = (i + 1) * (j + 1);
//            }
//        }
//        int[] ans = new int[m * n];
//        int count = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                ans[count++] = arr[i][j];
//            }
//        }
//        Arrays.sort(ans);
//        System.out.println(ans[m * n - k]);
//    }

    // 通过
    public static void main(String[] args) {
        // M*N的矩阵，其数值范围在1到M*N之间,题目给出长为n，宽(高)为m,即矩阵为m行n列
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int k_1 = m * n - k + 1;
        int left = 1, right = m * n + 1;
        while (left < right) {    // 循环跳出条件为left==right，区间左闭右开寻找
            int mid = left + (right - left) / 2;    // 二分取中间值
            // 求N*M的矩阵中有cnt个元素小于等于mid
            // 矩阵每一行的数据可以表示为[1*i,2*i,3*i,...n*i]
            int cnt = 0;
            // 根据矩阵的排列，可以直接求出前row行的数均小于mid
            int row = mid / n;
            cnt += row * n;
            for (int i = row + 1; i < m + 1; i++) {
                cnt += mid / i;
            }
            if (cnt < k_1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}