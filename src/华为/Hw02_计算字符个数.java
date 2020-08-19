package 华为;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 输入:
 * ABCDEF
 * A
 * <p>
 * 输出:
 * 1
 */
public class Hw02_计算字符个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        char[] chars = sc.next().toCharArray();
//        char c = chars[0];
        char c = sc.nextLine().charAt(0);

        System.out.println(solution(s, c));
    }

    public static int solution(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int solution2(String s, char c) {
        return s.toLowerCase().length() - s.toLowerCase().replaceAll(c + "".toLowerCase(), "").length();
    }
}
