package 笔试.浪潮;

import java.util.Scanner;

/**
 * 沙滩按照线型摆放着 n 个大小不一的球形石头，已知第 i 个石头的半径为 Ri ，且不存在两个石头有相同的半径，为了使石头
 * 摆放更加美观，现要求摆放的石头的半径从左往右依次递增，因此需要对一些石头进行移动。每次操作可以选择一个石头并把它放在
 * 剩下 n-1 个石头的最左边或最右边，问最少需要操作多少次才能将这 n 个石头的半径变成升序？
 * 1 <= n <= 100000    输出最少操作次数
 * <p>
 * 输入：
 * 5
 * 4 1 2 5 3
 * 输出：
 * 2
 *
 * 输入：
 * 6
 * 3 2 1 4 6 5
 * 输出：
 * 3
 */
public class Main {
    // 只需求出最大递增1的子序列长度，再用总长度减去子序列长度
    // AC 91%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1, max = 1;
        int n = sc.nextInt();
        if (n <= 100000) {
            int[] arr = new int[n];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                temp[i] = arr[i];
                for (int j = i + 1; j < n; j++) {
                    temp[j] = arr[j];
                    if (temp[i] + 1 == temp[j]) {
                        num += 1;
                        temp[i] = temp[j];
                    }
                }
                if (num > max) {
                    max = num;
                }
                num = 1;
            }
            System.out.println(n - max);
        }
    }
}