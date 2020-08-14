package 笔试.阿里;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 现有一个字符串它的构成是 岗位名称 和 , 的组合，如“研发,产品,产品,研发”，要求输入一个匹配模式，
 * 如xxyy(可以以这种简单的字符来标识), 来判断该字符串是否符合该模式， 举个例子：
 * <p>
 * 匹配模式 = "xyyx", 字符串 = "研发,产品,产品,研发" 返回 ture
 * 匹配模式 = "xxyy", 字符串 = "研发,产品,产品,研发" 返回 false
 * 匹配模式 = "yxxy", 字符串 = "研发,产品,产品,研发" 返回 ture
 */
public class StringMatch {
    public static void main(String[] args) {
        String s1 = "研发,产品,产品,研发";
        String s2 = "研发,产品,产品,研发";
        String s3 = "研发,产品,产品,研发";
        String pattern1 = "xyyx";
        String pattern2 = "xxyy";
        String pattern3 = "yxxy";
        System.out.println(solution(s1, pattern1));
        System.out.println(solution(s2, pattern2));
        System.out.println(solution(s3, pattern3));
    }

    public static boolean solution(String str, String pattern) {
        HashMap<Character, String> map = new HashMap<>();
        String[] split = str.split(",");   // 按 ","分割字符串
        boolean flag = true;
        if (pattern.length() != split.length) {  // 长度不相同直接置 false
            flag = false;
        }
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s)) {      // 比较和之前存入的是否相同，不同置 false
                    flag = false;
                    break;
                }
            } else {
                map.put(c, s);     // 不存在，加入到 map
            }
        }
        return flag;
    }
}