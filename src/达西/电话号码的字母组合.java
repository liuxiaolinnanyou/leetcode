package 达西;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 2 --- abc
 * 3 --- def
 * 4 --- ghi
 * 5 --- jkl
 * 6 --- mno
 * 7 --- pqrs
 * 8 --- tuv
 * 9 --- wxyz
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {

    }

    // 方法 1
    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.length() != 0) {
            backtrack("", digits, output);
        }
        return output;
    }

    private static void backtrack(String combination, String next_digits, List<String> output) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1), output);
            }
        }
    }


    // 方法 2
    private static final char[][] table = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        permute(res, digits, new StringBuilder());
        return res;
    }

    private static void permute(List<String> res, String digits, StringBuilder sb) {
        if (digits.length() == 0) {
            res.add(sb.toString());
            return;
        }
        for (char c : getChars(digits.charAt(0))) {
            sb.append(c);
            permute(res, digits.substring(1, digits.length()), sb);
            sb.deleteCharAt(sb.length() - 1); // 回溯主要体现在这部分
        }
    }

    private static char[] getChars(char c) {
        switch (c) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }
}