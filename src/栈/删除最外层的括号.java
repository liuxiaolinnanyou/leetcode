package 栈;

import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
public class 删除最外层的括号 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
        System.out.println(removeOuterParentheses("(())()()()()"));
    }

    // 方法 1
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {    // 这个if判断必须在下面的if判断的前面
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    // 方法 2
    /**
     * 遍历字符串，遇到左括号就入栈，遇到右括号就出栈，每次栈空的时候，都说明找到了一个原语，
     * 记录下每个原语的起始位置和结束位置，取原字符串在原语的起始位置 +1 到原语的结束位置的
     * 子串便得到原语删除了最外层括号的字符串，拼接，即可解出答案。
     */
    public static String removeOuterParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.isEmpty()) {       // 栈为空，表明一个原语的结束
                    sb.append(s.substring(start + 1, i));
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }

    // 方法 3   不使用栈
    public static String removeOuterParentheses3(String s) {
        int num = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                num++;
            }
            if (s.charAt(i) == ')') {
                num--;
            }
            if (num == 1 && s.charAt(i) == '(') {
                index = i;
            }
            if (num == 0) {
                sb.append(s.substring(index + 1, i));
            }
        }
        return sb.toString();
    }
}
