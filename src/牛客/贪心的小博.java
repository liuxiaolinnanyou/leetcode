package 牛客;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小博沉迷收集卡片，购买干脆面是他收集卡片的主要方式。他总共渴望的有N类卡片，均可通过购买干脆面获得，
 * 一包干脆面中有且仅有一张卡片，并且卡片类型对应N类卡片中的一种。且每种类型的卡片出现在一包干脆面中的概率是相等的。
 * 小博非常的贪心，他有N个愿望，第i个愿望即为:拥有至少pi张i类卡片，其中1 ≤ i ≤ N。
 * 然而，小博又极其贫困，他想知道最少需要买多少干脆面，使得在最坏情况下，至少能够满足他 N个愿望的其中一个。
 * <p>
 * 输入描述：
 * 第一行包含一个整数N， 1 ≤ N ≤ 105。
 * 第二行包含N个整数pi，pi表示小博希望至少拥有的i类卡片数量。1 ≤ pi ≤ 105。
 * 输出描述：
 * 输出一个整数ANS，小博可以完成至少一个愿望需要购买的最少的干脆面的数量。
 * <p>
 * 输入：
 * 3
 * 8 6 9
 * 输出：
 * 21
 * <p>
 * 输入：
 * 2
 * 3 5
 * 输出：
 * 7
 */
public class 贪心的小博 {
    // int只能通过90%    使用long
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans += arr[i] - 1;
        }
        System.out.println(ans);
    }
}
