package 笔试.京东;

import java.util.Scanner;

/**
 * 现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数。
 * 回文素数是指一个素数同时还是一个回文数(一位数也被认为是回文数)
 * 输入两个正整数 N 和 M ，满足N < M ，请编写一个程序统计N和M之间存在多少个满足上述要求的数。
 * <p>
 * 输入描述：
 * 单组输入，输入一行，包含两个正整数N和M，1 <= N < M <=1000000 两个数字之间用空格隔开。
 * 输出描述：
 * 输出在N和M之间(包含N和M)满足要求的数的个数。
 * <p>
 * 输入： 110 120
 * 输出： 10
 * 提示：
 * 10个数分别是 110 111 112 113 114 115 116 117 118 119
 */
// 只通过 36%
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        for (int i = n; i <= m; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0; j < s.length(); j++) {
                StringBuilder sb2 = sb.deleteCharAt(j);
                String substring = sb2.toString();
                while (substring.startsWith("0")) {
                    substring = sb2.substring(1);
                }
                if (help(substring) && isPrime(substring)) {
                    count++;
                    break;
                }
                sb = new StringBuilder(s);
            }
        }
        System.out.println(count);
    }

    public static boolean help(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static boolean isPrime(String s) {
        int i = Integer.parseInt(s);
        for (int x = 2; x < Math.sqrt(i); x++) {
            if (i % x == 0) {
                return false;
            }
        }
        return true;
    }
}
