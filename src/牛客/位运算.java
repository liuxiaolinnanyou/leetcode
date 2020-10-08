package 牛客;

import java.util.Scanner;

/**
 * 两个int32整数m和n的二进制表达，计算有多少个位(bit)不同？
 * <p>
 * 输入描述：一行中给定两个数字
 * 输出描述：输出这两个数字中bit不同的个数
 * <p>
 * 输入：15 8
 * 输出：3
 */
public class 位运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int xor = sc.nextInt() ^ sc.nextInt();
//            System.out.println(xor);
            int count = 0;
            while (xor != 0) {
                xor &= xor - 1;
                count++;
            }
            System.out.println(count);
        }
    }
}