package 牛客;

import java.util.Scanner;

/**
 * 由数字 1 到 n 组成的一个序列我们称为一个 n 排列。
 * 对于两个不同的 n 排列𝐴 = 𝑎1𝑎2 ... 𝑎𝑛和 𝐵 = 𝑏1𝑏2 ... 𝑏𝑛我们可以按字典序比较他们的大小:
 * 从前往后找到第一个两个排列中数字不同 的位置，
 * 即找到一个位置𝑝使得𝑎1 = 𝑏1, 𝑎2 = 𝑏2, ... , 𝑎𝑝−1 = 𝑏𝑝−1, 𝑎𝑝 ≠ 𝑏𝑝，若𝑎𝑝 < 𝑏𝑝，
 * 我们 则称排列𝐴小于排列𝐵，反之则𝐴大于𝐵。现在给出一个 n 排列，你需要选择排列中的两个不同的位置，
 * 然后交换这两个位置的数字， 你需要使得最后得到的排列尽量小。注意你必须进行一次且只能进行一次操作。
 * <p>
 * 输入描述：
 * 第一行包含一个数字𝑛，表示排列的长度。2 ≤ 𝑛 ≤ 105
 * 第二行包含𝑛个数字构成一个𝑛排列。
 * 输出描述：
 * 输出一个 n 排列，表示能得到的最小的排列。
 * <p>
 * 输入：
 * 3
 * 3 2 1
 * 输出：
 * 1 2 3
 * <p>
 * 输入：
 * 4
 * 2 1 4 3
 * 输出：
 * 1 2 4 3
 */
public class 最小排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        solve(n, a);
        for (int i = 1; i <= n - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(a[n]);
    }

    private static void solve(int n, int[] a) {
        for (int i = 1; i <= n; i++) {
            if (a[i] == i) {
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                if (a[j] == i) {
                    a[j] = a[i];
                    a[i] = i;
                    return;
                }
            }
        }
        a[n] = n - 1;
        a[n - 1] = n;
    }
}
