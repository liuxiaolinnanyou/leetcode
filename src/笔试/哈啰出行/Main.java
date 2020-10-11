package 笔试.哈啰出行;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出其中连续的不含重复字符的最长子串，如果有多个相同长度的，只取第一个即可。
 */
public class Main {
    public static void main(String[] args) {
        String s = "abcdbcdcbabcdefggcwa";
        String ss = "The Linux kernel is an open source software project of fairly large scope.";
        System.out.println(findMaxSubstr(s));
        System.out.println(findMaxSubstr(ss));
    }

    public static String findMaxSubstr(String str) {
        // write code here
        int n = str.length();
        int ans = 0;
        ArrayList<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = str.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(str.charAt(end), end + 1);
            list.add(str.substring(start, end + 1));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == ans) {
                return list.get(i);
            }
        }
        return null;
    }
}