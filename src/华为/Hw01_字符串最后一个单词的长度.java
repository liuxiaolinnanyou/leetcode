package 华为;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * <p>
 * 输入:
 * hello world
 * 输出:
 * 5
 */
public class Hw01_字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(solution(s));
        }
    }

    // 这道题的另一种解法参考   二轮中的最后一个单词的长度
    public static int solution(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }
}