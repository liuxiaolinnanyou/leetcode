package 栈;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class 有效的括号 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        System.out.println(stack.empty());     // 线程不安全的
        System.out.println(stack.isEmpty());   // 线程安全的
        System.out.println("--------------------");

        stack.peek();  // 不删除
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());
        System.out.println("--------------------");

        stack.pop();   // 删除
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());


//        System.out.println(isValid("()"));
//        System.out.println(isValid("()[]{}"));
//        System.out.println(isValid("(]"));
//        System.out.println(isValid("([)]"));
//        System.out.println(isValid("{[]}"));
//        System.out.println("----------------------------------");
//        System.out.println(isValid2("()"));
//        System.out.println(isValid2("()[]{}"));
//        System.out.println(isValid2("(]"));
//        System.out.println(isValid2("([)]"));
//        System.out.println(isValid2("{[]}"));
    }

    // 方法 1  使用栈存放左括号
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {          // 奇数个字符的字符串 显然无法完成括号匹配
            return false;
        }
        // 使用 栈 实现
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char theChar = s.charAt(i);
            if (theChar == '(' || theChar == '{' || theChar == '[') {
                stack.push(theChar);
            } else {
                if (stack.empty()) {         // 栈中已无左括号，此时字符为右括号，无法匹配。
                    return false;
                }
                char preChar = stack.peek();  // 不删除
                if ((preChar == '{' && theChar == '}') || (preChar == '(' && theChar == ')') || (preChar == '[' && theChar == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }


    // 方法 2    去掉了栈的封装
    public static boolean isValid2(String s) {
        // 用 数组 代替 栈 实现
        char[] charArray = new char[s.length() + 1];
        int p = 1;
        for (char c : s.toCharArray()) {    // 转换成字符数组
            if (c == '(' || c == '{' || c == '[') {
                charArray[p++] = c;
            } else {
                p--;
                if (c == ')' && charArray[p] != '(') {
                    return false;
                }
                if (c == '}' && charArray[p] != '{') {
                    return false;
                }
                if (c == ']' && charArray[p] != '[') {
                    return false;
                }
            }
        }
        return p == 1;   // 如果左括号还有剩余 括号没有一一对应，属于无效情况
    }
}