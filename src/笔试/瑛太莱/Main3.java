package 笔试.瑛太莱;

// 假设你有 n 颗糖，将这些糖摆成 m 行，每行的糖个数等于当前行数。
// 输入：10
// 输出：4

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = (int) Math.sqrt((double) 2 * n);
        int x = left * (left + 1);
        if (2 * n == x) {
            System.out.println(left);
        } else {
            while (2 * n > x) {
                left++;
                x = left * (left + 1);
            }
            System.out.println(left - 1);
        }
    }
}