package 华为;

import java.util.Scanner;

/**
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
 * <p>
 * 输入参数：
 * inputString：输入的字符串      输入一个字符串，可以有空格
 * <p>
 * 返回值：
 * 输出转换好的逆序字符串          输出逆序的字符串
 * <p>
 * 输入：I am a student
 * 输出：tneduts a ma I
 */
public class Hw106_字符逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }

    // 方法 1
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 方法 2
    public static String reverse2(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str = str + s.substring(i, i + 1);
        }
        return str;
    }
}
