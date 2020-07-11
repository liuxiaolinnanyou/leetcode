package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    // 暴力法
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {   // 验证通过则添加
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    // dfs
    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }

    private static void dfs(int left, int right, String curStr, List<String> res) {
        if (left == 0 && right == 0) {    // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) {                  // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(", res);
        }
        if (right > left) {              // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")", res);
        }
    }
}
