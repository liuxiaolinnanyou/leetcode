package 十三轮;

import java.util.Scanner;

/**
 * 输入一个自然数，若为偶数，则把它除以2，若为奇数，则把它乘以3加1，经过如此有限次运算后，总可以得到自然数1。
 * 求经过多少次可得到自然数1。
 * <p>
 * 输入：22
 * 输出：22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * step=16
 */
public class 角谷定理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int count = 0;
        while (m != 1) {
            if (m % 2 == 0) {
                System.out.println(m);
                m = m / 2;
                count++;
            } else {
                System.out.println(m);
                m = m * 3 + 1;
                count++;
            }
        }
        System.out.println(m);
        System.out.println(count);
    }
}