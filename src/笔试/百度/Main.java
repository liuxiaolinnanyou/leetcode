package 笔试.百度;

import java.util.Scanner;

/**
 * 牛牛有n张卡片，每张卡片要么是0，要么是5，，牛牛能从其中选出若干张卡片组成一些数字，现在牛牛想请你找出所有可能的数字中
 * 能整除90的最大数字，若不存在则输出-1.
 * <p>
 * 输入：
 * 11
 * 5 5 5 5 5 5 5 5 0 5 5
 * 输出：5555555550
 */
// AC 80
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count_5 = 0;
        int count_0 = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 5) {
                count_5++;
            }
            if (num == 0) {
                count_0++;
            }
        }
        if (count_0 == 0) {
            System.out.println(-1);
            return;
        }
        if (count_5 == 0) {
            System.out.println(-1);
            return;
        }
        while ((count_5 * 5) % 9 != 0) {
            count_5--;
        }
        if (count_5 == 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();

        while (count_5 != 0) {
            sb.append("5");
            count_5--;
        }
        while (count_0 != 0) {
            sb.append("0");
            count_0--;
        }
        System.out.println(sb.toString());
    }
}