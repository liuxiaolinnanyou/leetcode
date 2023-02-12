package 华为;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * 数据范围：0 <= n <= 2^30 - 1
 * <p>
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 */
public class Hw11_数字颠倒 {
    // 1.使用StringBuffer  reverse()方法
    // 2.通过String.valueOf()将输入的整数转为字符串，然后反向遍历输出
    // 3.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}