package 十一轮;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * <p>
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class 计算器 {
    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate2(" 3+5 / 2 "));
    }

    // 1. 如果碰到数字， 则把数字入栈
    // 2. 如果碰到空格， 则继续下一步
    // 3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
    //    A.如果是'+', 下一个数字num直接入栈
    //    B.如果是'-'，-num入栈
    //    C.如果是'*', num = stack.pop() * num, 入栈
    //    D.如果是'/', num = stack.pop() / num, 入栈
    // 4. 最后，把栈里的数相加就是结果
    public static int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int i = 0;
        while (i < cs.length) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            char temp = cs[i];
            if (temp == '*' || temp == '/' || temp == '+' || temp == '-') {
                i++;
                while (i < cs.length && cs[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            while (i < cs.length && Character.isDigit(cs[i])) {
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch (temp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }


    public static int calculate2(String s) {
        s = s.replace(" ", ""); // 去除空格  方便后续操作
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ) {
            int value = 0;
            char symbol = s.charAt(i);
            if (symbol == '*' || symbol == '/' || symbol == '-' || symbol == '+') {
                i++;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                value = 10 * value + (int) s.charAt(i++) - 48;
            }
            if (symbol == '*') {
                value = queue.removeLast() * value;
            }
            if (symbol == '/') {
                value = queue.removeLast() / value;
            }
            if (symbol == '-') {
                value = -value;
            }
            queue.add(value);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }
}
