package 笔试.用友;

import java.util.Scanner;

/**
 * 压缩字符串
 * 输入：
 * abbcccaadddd
 * 输出：
 * a1b2c3a2d4
 * <p>
 * 注意：
 * 当压缩字符串长度小于等于原字符串时输出压缩字符串
 * 否则输出原字符串。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(compress(s));
    }

    public static String compress(String str) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            sb.append(str.charAt(i));
            int sum = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i += 1;
                sum += 1;
            }
            sb.append(sum);
            i += 1;
        }
        if (sb.toString().length() <= str.length()) {
            return sb.toString();
        } else {
            return str;
        }
    }
}