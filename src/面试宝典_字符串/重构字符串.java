package 面试宝典_字符串;

import java.util.Arrays;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 */
public class 重构字符串 {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 100;   // 加上 100 是为不受字母序号（最大26）的影响
        }
        for (int i = 0; i < 26; i++) {
            count[i] += i;
        }
        Arrays.sort(count);
        char[] ans = new char[n];
        int t = 1;
        for (int code : count) {
            int cnt = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (cnt > (n + 1) / 2) {
                return "";
            }
            for (int i = 0; i < cnt; i++) {
                if (t >= n) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }
}