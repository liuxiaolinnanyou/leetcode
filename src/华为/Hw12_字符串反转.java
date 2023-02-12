package 华为;

import java.util.Scanner;

/**
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * 输出描述：
 * 输出该字符串反转后的字符串。
 * <p>
 * 输入：
 * abcd
 * 输出：
 * dcba
 */
public class Hw12_字符串反转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}