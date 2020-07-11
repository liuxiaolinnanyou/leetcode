package 携程;

import java.util.Scanner;

/**
 * 输入一个long类型的数值, 求该数值的二进制表示中的1的个数.
 * <p>
 * 输入描述：
 * long 类型的数值
 * 输出描述：
 * 该数值二进制表示中1的个数
 * <p>
 * 输入例子：3
 * 输出例子：2     3的二进制表示: 11, 所以1个数为2
 * <p>
 * 输入：65
 * 输出：2        65的二进制为:1000001，所以１的个数为：２
 */
public class BitCount {
    public static void main(String[] args) {
        // 只能通过33.3%
//        Scanner sc = new Scanner(System.in);
//        long n = sc.nextLong();
//        int bitCount = Integer.bitCount((int) n);
//        System.out.println(bitCount);

        // 全部通过
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
    }
}
