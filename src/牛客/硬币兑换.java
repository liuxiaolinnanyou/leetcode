package 牛客;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A 国一共发行了几种不同面值的硬币，分别是面值 1 元，2 元，5 元，10 元，20 元，50 元， 100 元。
 * 假设每种面值的硬币数量是无限的，现在你想用这些硬币凑出总面值为 n 的硬币， 同时你想让选出的硬币中，
 * 不同的面值种类尽可能多;在面值种类尽可能多的情况下，你想让选择的硬币总数目尽可能多，请问应该怎么选择硬币呢?
 * <p>
 * 输入描述：第一行包含一个数字𝑛，表示要凑出的面值。1 ≤ 𝑛 ≤ 109
 * 输出描述：输出两个整数，分别表示最多能有多少种类型的硬币以及在类型最多的情况下最多能用上多少枚硬币。
 * <p>
 * 输入：3
 * 输出：2 2
 * <p>
 * 输入：10
 * 输出：3 5
 */
public class 硬币兑换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {1, 2, 5, 10, 20, 50, 100};
        int[] sum = new int[8];
        for (int i = 1; i < 8; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];      // [0, 1, 3, 8, 18, 38, 88, 188]
        }
//        System.out.println(Arrays.toString(sum));
        // 策略为从小到大,每种面值的硬币用一个,剩下的全部用面值为1的硬币填充
        for (int i = sum.length - 1; i > 0; i--) {
            if (n >= sum[i]) {
                System.out.println(i + " " + (n - sum[i] + i));    // n - sum[i]   用 1 元硬币填充的数目
                break;
            }
        }
    }
}
