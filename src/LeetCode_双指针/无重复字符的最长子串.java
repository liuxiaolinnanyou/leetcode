package LeetCode_双指针;

import java.util.HashMap;
import java.util.Map;

/*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
          请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
//        String s1 = "abcabcbb";
//        String s2 = "bbbbb";
        String s3 = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        // map 集合中存储的是字符以及该字符在字符串中后一个字符的索引
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                // 存在重复字符 修改 start 的值
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);     // 字符串的长度
            map.put(s.charAt(end), end + 1);          // 记录的是该字符的后一个位置的索引
        }
        return ans;
    }
}
