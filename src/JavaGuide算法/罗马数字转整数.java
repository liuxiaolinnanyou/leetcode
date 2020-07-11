package JavaGuide算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: "III"
 * 输出: 3
 * <p>
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class 罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(remanToInt("III"));
        System.out.println(remanToInt("IV"));
        System.out.println(remanToInt("IX"));
        System.out.println(remanToInt("LVIII"));
        System.out.println(remanToInt("MCMXCIV"));
        System.out.println("-----------------------------");
        System.out.println(remanToInt2("III"));
        System.out.println(remanToInt2("IV"));
        System.out.println(remanToInt2("IX"));
        System.out.println(remanToInt2("LVIII"));
        System.out.println(remanToInt2("MCMXCIV"));
    }

    // 方法 1
    public static int remanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;     // 最后一位
        return sum;
    }

    public static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    // 方法 2
    public static int remanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}
