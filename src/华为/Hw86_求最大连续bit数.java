package 华为;

import java.util.Scanner;

/**
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * <p>
 * 输入描述:
 * 输入一个byte数字
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 * <p>
 * 输入：
 * 3
 * 输出：
 * 2
 */
public class Hw86_求最大连续bit数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(count(num));
        }
    }

    public static int count(int n) {
        String s = Integer.toBinaryString(n);
        String[] strings = s.split("0+");   // 将字符串按多个0分割
        int count = 0;
        for (String str : strings) {
            count = Math.max(count, str.length());
        }
        return count;
    }
}