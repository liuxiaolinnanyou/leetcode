package 面试宝典_字符串;

import sun.applet.Main;

/**
 * 假设字符串中的所有字符都不重复，如何输出字符串的所有组合？例如： 输入"abc"，则输出a、b、c、ab、ac、bc、abc。共7种组合。
 */
public class 输出字符串的所有组合 {
    // 根据题意，如果字符中有n个字符，根据排列组合的性质，此时一共需要输出2^n-1种组合。
    public static void main(String[] args) {
//        String s = "abc";
//        combine(s);

        String s = "abc";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        int len = c.length;
        for (int i = 1; i <= len; i++) {
            combine2(c, 0, i, sb);
        }
    }

    /**
     * 可以构造一个长度为n的01字符串表示输出结果中是否包含某个字符，例如:"001"表示输出结果中不含字符a、b，只含c，即输出结果为c。而
     * "101"表示输出结果为ac。原题就是要求输出"001"到"111"这2^n-1个组合对应的字符串。
     */
    public static void combine(String s) {
        char[] c = s.toCharArray();
        if (c == null) {
            return;
        }
        int len = s.length();
        boolean[] used = new boolean[len];
        char[] cache = new char[len];
        int result = len;
        while (true) {
            int index = 0;
            while (used[index]) {
                used[index] = false;
                ++result;
                if (++index == len) {
                    return;
                }
            }
            used[index] = true;
            cache[--result] = c[index];
            System.out.println(new String(cache).substring(result));
        }
    }

    // 递归
    public static void combine2(char[] c, int begin, int len, StringBuffer sb) {
        if (len == 0) {
            System.out.println(sb);
            return;
        }
        if (begin == c.length) {
            return;
        }
        sb.append(c[begin]);
        combine2(c, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        combine2(c, begin + 1, len, sb);
    }
}
