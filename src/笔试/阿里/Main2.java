package 笔试.阿里;

/**
 * 共有n个人，每个人抽到一个初始序号，如果某个人的序号是某个数的平方，那么他就会获奖，现在会发放
 * 一些数量的修改券，使用一张修改券可以使自己的序号加一或者减一，现在想知道，如果想让一半人可以获奖
 * 至少需要发放多少张修改券。
 * <p>
 * 输入描述：第一行一个正整数，测试数据保证为偶数，表示人数n
 * 第二行n个正整数，表示每个人的初始序号
 * 输出描述：一个正整数，表示至少需要发放的修改券
 * <p>
 * 输入：
 * 4
 * 4 7 12 13
 * <p>
 * 输出：
 * 2
 * <p>
 * 说明：4不用修改，7使用两张变为9.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        int res = putNums(arr, n);
        System.out.println(res);
    }

    private static int putNums(int[] arr, int n) {
        int[] minNeed = new int[n];
        for (int i = 0; i < n; i++) {
            int sq = (int) (Math.sqrt(arr[i]));
            int sq1 = sq + 1;
            minNeed[i] = Math.min((arr[i] - sq * sq), (sq + 1) * (sq + 1) - arr[i]);
        }
        Arrays.sort(minNeed);
        int res = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            res += minNeed[i];
        }
        return res;
    }
}