package 达西;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println("方法1");
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println("----------------------------------");
        System.out.println("方法2");
        System.out.println(longestValidParentheses2("(()"));
        System.out.println(longestValidParentheses2(")()())"));
        System.out.println("----------------------------------");
        System.out.println("方法3");
        System.out.println(longestValidParentheses3("(()"));
        System.out.println(longestValidParentheses3(")()())"));
    }

    // 方法 1   使用栈
    // 如果遇到左括号我们就把他的下标压栈，如果遇到右括号说明和栈顶元素匹配，
    // 那么栈顶元素比如m出栈，用当前元素的下标减去新的栈顶元素的值，
    // 为什么减去新的栈顶元素值，这是因为新的栈顶元素还没匹配成功，
    // 之前的栈顶元素m到现在元素的下标之间构成了有效的括号
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // 方法 2    暴力法
    public static int longestValidParentheses2(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ')') {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '(' || ((j - i + 1) & 1) == 1) {
                    continue;
                }
                if (isValid(s.substring(i, j + 1))) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    // 方法 3     动态规划法
    public static int longestValidParentheses3(String s) {
        int max = 0;
        s = " " + s;
        int dp[] = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
