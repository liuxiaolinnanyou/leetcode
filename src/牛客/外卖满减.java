package 牛客;

import java.util.Scanner;

/**
 * 你打开了美了么外卖，选择了一家店，你手里有一张满X元减10元的券，店里总共有n种菜，第i种菜一份需要A_i元，
 * 因为你不想吃太多份同一种菜，所以每种菜你最多只能点一份，现在问你最少需要选择多少元的商品才能使用这张券。
 * <p>
 * 输入描述：第一行两个正整数n和X，分别表示菜品数量和券的最低使用价格。（1≤n≤100, 1≤X≤10000）
 * 接下来一行n个整数，第i个整数表示第i种菜品的价格。（1≤A_i≤100）
 * 输出描述：一个数，表示最少需要选择多少元的菜才能使用这张满X元减10元的券，保证有解。
 * <p>
 * 输入：
 * 5 20
 * 18 19 17 6 7
 * 输出：
 * 23
 */
public class 外卖满减 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] xs = new int[x + 1];
        for (int i = 0; i <= x; i++) {
            xs[i] = 10001;
        }
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            for (int j = x; j >= 0; j--) {
                if (j > price) {
                    // 如果凑单价格大于当前price，那么就看下原来的凑单价最小还是
                    // 当前菜品的价格，加上j-price的价格最少需要多少元凑单
                    xs[j] = Math.min(xs[j], xs[j - price] + price);
                } else {
                    // 如果当前凑单价格小于等于price，必须点当前price的菜，除非有比当前价格更小的菜
                    xs[j] = Math.min(xs[j], price);
                }
            }
        }
        System.out.println(xs[x]);
    }
}
