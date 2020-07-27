package 华为;

import java.util.Scanner;

/**
 * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * 注意：输入数据可能有多行
 * <p>
 * 输入描述:
 * 输入一个字符串
 * <p>
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * <p>
 * 输入：Jkdi234klowe90a3
 * 输出：Jkdi*234*klowe*90*a*3*
 */
public class Hw96_表示数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(markNum(s));
            System.out.println(markNum2(s));
        }
    }

    public static String markNum(String s) {
        return s.replaceAll("([0-9]+)", "*$1*");
    }

    // 有问题
    // ab*12cd
    // ab**cd
    public static String markNum2(String s) {
        char[] charArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            if ((charArray[i] - '0' >= 0) && (charArray[i] - '0' <= 9)) {
                sb.append("*" + charArray[i] + "*");
            } else {
                sb.append(charArray[i]);
            }
        }
        return sb.toString().replaceAll("\\*\\*", "");
    }
}