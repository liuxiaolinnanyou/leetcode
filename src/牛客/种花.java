package 牛客;

import java.util.Scanner;

/**
 * 公园里有N个花园，初始时每个花园里都没有种花，园丁将花园从1到N编号并计划在编号为i的花园里恰好种A_i朵花，
 * 他每天会选择一个区间[L，R]（1≤L≤R≤N）并在编号为L到R的花园里各种一朵花，那么园丁至少要花多少天才能完成计划？
 * <p>
 * 输入描述：
 * 第一行包含一个整数N，1≤N≤10^5。
 * 第二行包含N个空格隔开的整数A_1到A_N，0≤A_i≤10^4。
 * 输出描述：
 * 输出完成计划所需的最少天数。
 * <p>
 * 输入：
 * 5
 * 4 1 8 2 5
 * 输出：
 * 14
 */
public class 种花 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] target = new int[n];
        for (int i = 0; i < n; ++i) {
            target[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (target[i - 1] > target[i]) {
                cnt += target[i - 1] - target[i];
            }
        }
        System.out.println(cnt + target[n - 1]);
    }
}
