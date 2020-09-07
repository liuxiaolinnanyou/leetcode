package 十一轮;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 *
 * 输出: 23
 * <p>
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class 基本计算器 {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();        // 数据栈
        Stack<Character> symbol = new Stack<>();     // 符号栈

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            // 处理数字字符
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                i++;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;       // 回退
                stack.push(num);
            }
            // 处理括号
            if (c == '(') {
                symbol.push('(');
            }
            if (c == ')') {
                int res = 0;
                if (symbol.peek() == '(') {
                    res = stack.pop();
                } else {
                    while (true) {
                        int add_sub1 = symbol.pop() == '+' ? 1 : -1;
                        int num1 = stack.pop() * add_sub1;
                        res = num1 + res;
                        if (symbol.peek() == '(') {
                            res += stack.pop();
                            break;
                        }
                    }
                }
                symbol.pop();
                stack.push(res);
            }
            // 处理运算符
            if (c == '+' || c == '-') {
                symbol.push(c);
            }
        }

        // 计算的过程
        int res = 0;
        while (!stack.empty()) {
            while (true) {
                int add_sub1 = (symbol.empty() || symbol.pop() == '+') ? 1 : -1;
                int num1 = stack.pop() * add_sub1;
                res = num1 + res;
                if (symbol.empty()) {
                    break;
                }
            }
            if (!stack.empty()) {
                res = stack.pop() + res;
            }
        }
        return res;
    }
}