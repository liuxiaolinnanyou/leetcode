package 六轮;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses2("25525511135"));
    }

    // 暴力法
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder ip = new StringBuilder();

        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        /*
                         * 1、保障下面subString不会越界
                         * 2、保障截取的字符串与输入字符串长度相同
                         * // 1、2比较好理解，3比较有意思
                         * 3、不能保障截取的字符串转成int后与输入字符串长度相同
                         * 如：字符串010010，a=1，b=1，c=1，d=3，对应字符串0，1，0，010
                         * 转成int后seg1=0，seg2=1，seg3=0，seg4=10
                         * // 所以需要下面这处判断if (ip.length() == s.length() + 3)
                         */
                        if (a + b + c + d == s.length()) {
                            int seg1 = Integer.parseInt(s.substring(0, a));
                            int seg2 = Integer.parseInt(s.substring(a, a + b));
                            int seg3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int seg4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            // 四个段数值满足0~255
                            if (seg1 <= 255 && seg2 <= 255 && seg3 <= 255 && seg4 <= 255) {
                                ip.append(seg1).append(".").append(seg2).append(".").
                                        append(seg3).append(".").append(seg4);
                                // 保障截取的字符串转成int后与输入字符串长度相同
                                if (ip.length() == s.length() + 3) {
                                    result.add(ip.toString());
                                }
                                ip.delete(0, ip.length());    // 清空
                            }
                        }
                    }
                }
            }
        }
        return result;
    }


    // 回溯法
    public static List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    // cur : 当前答案，以 String List的形式，最后再join成String形式 例如 [[255],[255],[111],[35]] -> 255.255.111.35
    // pos, 当前扫描到的s的位置， ans最终答案
    private static void backtracking(String s, int pos, List<String> cur, List<String> ans) {
        if (cur.size() >= 4) {
            if (pos == s.length()) {
                ans.add(String.join(".", cur));     // 以 . 分隔
            }
            return;
        }
        // 分割得到ip地址的一段后，下一段只能在长度1-3范围内选择
        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            // 剪枝条件：不能以0开头，不能大于255
            if ((segment.startsWith("0") && segment.length() > 1) || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            // 注意此处传的参数
            backtracking(s, pos + i, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
