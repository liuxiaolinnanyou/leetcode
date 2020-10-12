package 面试宝典_字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 删除字符串中重复的字符 例如："good"变为"god"。
 */
public class 删除字符串中的重复元素 {
    public static void main(String[] args) {
//        String s = "'\0'";
//        System.out.println((char) '\0');

//        System.out.println('\0' + 1);     // 空子符的 ASCII 码为 0

        String s = "abcaabcd";
        System.out.println(removeDuplicate(s));
        System.out.println(removeDuplicate2(s));
        System.out.println(removeDuplicate3(s));
    }

    // 暴力法
    public static String removeDuplicate(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '\0') {     // 空字符
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (chars[j] == '\0') {
                    continue;
                }
                // 把重复的字符置为 '\0'
                if (chars[i] == chars[j]) {
                    chars[j] = '\0';
                }
            }
        }
        int l = 0;
        // 去掉'\0'
        for (int i = 0; i < len; i++) {
            if (chars[i] != '\0') {
                chars[l++] = chars[i];
            }
        }
        return new String(chars, 0, l);
    }

    // 方法 2
    public static String removeDuplicate2(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : chars) {
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }


    // 方法 3 自己写的
    public static String removeDuplicate3(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                continue;
            } else {
                list.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}