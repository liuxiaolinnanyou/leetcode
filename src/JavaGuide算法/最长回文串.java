package JavaGuide算法;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含大小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如“Aa”不能当做一个
 * 回文字符串。注意：假设字符串的长度不会超过1010。
 * <p>
 * 输入：abccccdd  输出：7
 * 我们可以构造的最长回文串是"dccaccd"，它的长度是7。
 */
public class 最长回文串 {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("abc"));
    }

    // 字符出现次数为双数的组合
    // 字符出现次数为双数的组合 + 一个只出现一次的字符
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用于存放字符
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
            } else {
                set.remove(chars[i]);
                count++;
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}