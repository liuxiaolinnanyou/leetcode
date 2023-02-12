package 华为;

import java.util.Scanner;
import java.util.Stack;

public class Hw54_表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            process(str);
        }
    }

    public static void process(String str) {
        String s1 = str.replace("[", "(");
        String s2 = s1.replace("]", ")");
        String s3 = s2.replace("{", "(");
        String s4 = s3.replace("}", ")");
        int res = solve(s4);
        System.out.println(res);
    }

    private static int solve(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char[] chs = str.toCharArray();
        // number 记录数字
        int len = str.length(), number = 0;
        // 初始化符号为 '+'
        char sign = '+';
        // 处理表达式
        for (int i = 0; i < len; i++) {
            char c = chs[i];
            if (c == ' ') {
                // 遇到空格跳过
                continue;
            }
            // 如果是数字，拼接数字
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            // 如果是小括号
            if (c == '(') {
                // 移动到括号后一位  count统计括号数
                int j = i + 1, count = 1;
                while (count > 0) {
                    // 统计当前 ( 开始包含的表达式，直到对应的 ) 停止
                    if (chs[j] == ')') count--;  // 左括号-1
                    if (chs[j] == '(') count++;  // 右括号+1
                    j++;
                }
                number = solve(str.substring(i + 1, j - 1));
                // 更新下标
                i = j - 1;
            }
            // 遇到符号或者最后一位了
            if (!Character.isDigit(c) || i == len - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                // 更新符号
                sign = c;
                // 更新数字
                number = 0;
            }
        }
        // 栈中数字求和得到结果
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}