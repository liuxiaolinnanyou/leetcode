package 笔试.vivo;

import java.util.Scanner;

/**
 * 回文字符串就是正读和反读都一样的字符串，如"viv","12321","qqq","翻身把身翻"等
 * 给定一个非空字符串 str , 在最多可以删除一个字符的情况下请编程判定其能否成为回文字符串
 * 如果可以，则输出首次删除一个字符所能得到的回文字符串，如果不行则输出字符串"false"。
 * <p>
 * 输入：abda
 * 输出：ada
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            String s = sb.deleteCharAt(i).toString();
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                return s;
            }
            sb = new StringBuilder(str);
        }
        return "false";
    }
}