package 字节跳动;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，
 * 且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。
 * 给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。
 * <p>
 * 输入描述:
 * 城市个数n（1< n ≤20，包括北京）
 * 城市间的车票价钱 n行n列的矩阵 m[n][n]
 * <p>
 * 输出描述:
 * 最小车费花销 s
 * <p>
 * 输入例子1:
 * 4
 * 0 2 6 5
 * 2 0 4 4
 * 6 4 0 2
 * 5 4 2 0
 * 输出例子1:
 * 13
 * 例子说明1:
 * 共 4 个城市，城市 1 和城市 1 的车费为0，城市 1 和城市 2 之间的车费为 2，城市 1 和城市 3 之间的车费为 6，
 * 城市 1 和城市 4 之间的车费为 5，依次类推。假设任意两个城市之间均有单程票可购买，且票价在1000元以内，无需考虑极端情况。
 */
public class 毕业旅行问题 {
    // 规律 对于每一行选出最小的 ，选择后该列就不能再选    不知道是否可行
    // 回溯法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[] vis = new boolean[n];    // 记录各个城市访问情况
        vis[0] = true;
        AtomicInteger ans = new AtomicInteger(Integer.MAX_VALUE);
        dfs(arr, vis, n, 0, 1, 0, ans);
        System.out.println(ans.get());
    }

    // vn为已经访问的城市数量,local为当前城市编号,price为当前累计票价
    private static void dfs(int[][] arr, boolean[] vis, final int n, int local, int vn, int price, AtomicInteger ans) {
        if (price > ans.get()) {    // 如果此时价格已经超出了之前找到的最小价格，那么进行剪支操作
            return;
        }
        if (vn == n) {        // 如果已经遍历完成
            int val = price + arr[local][0];    // 因为走完所有城市后还要回到起点所以加上arr[local][0]
            if (val < ans.get()) {
                ans.set(val);
            }
            return;
        }
        for (int i = 1; i < n; i++) {     // 因为起点为0所以无需考虑起点
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            dfs(arr, vis, n, i, vn + 1, price + arr[local][i], ans);   // 继续遍历
            vis[i] = false;
        }
    }
}
