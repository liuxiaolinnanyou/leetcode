package 面试宝典_字符串;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 由相同的字符组成是指组成两个字符串的字母以及各个字母的个数是一样的，只是排列的顺序不同而已。例如：
 * "aaaabbc"和"abcbaaa"就由相同的字符组成的。
 */
public class 两个字符串是否由相同的字符组成 {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        byte[] bytes = "中国".getBytes("utf-8");
//        for (int i : bytes) {
//            System.out.println(i);
//        }

        String s1 = "aaaabbc";
        String s2 = "abcbaaa";
        compare(s1, s2);
        compare("aaaabbc", "abcbaab");
    }

    // 方法1  排序法
    public static void compare(String s1, String s2) {
        // 获取对应的字节数组
        byte[] by1 = s1.getBytes();
        byte[] by2 = s2.getBytes();
        Arrays.sort(by1);
        Arrays.sort(by2);
        s1 = new String(by1);
        s2 = new String(by2);
        if (s1.equals(s2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
