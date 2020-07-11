package 栈;

import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 输入: "bcabc"
 * 输出: "abc"
 * <p>
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 */
public class 去除重复字母 {
    public static void main(String[] args) {
        String s = "bbcaacb";
        System.out.println(removeDuplicateLetters(s));

        String s2 = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s2));

        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        /**
         * 若栈中已经有当前元素，则直接去除当前元素
         * 若当前的栈顶元素比当前的元素字典序大，且当前元素的位置后面还有栈顶元素,
         * 将栈顶元素出栈, 将当前元素入栈, 这样来找到最优的排列
         */
        Stack<Character> stack = new Stack<>();
//        Queue<Character> queue = new LinkedList<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 1
            if (stack.contains(c)) {
                continue;
            }
            // 2
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                // indexOf()  第一个参数 查找的字符      第二个参数 从指定索引开始查找
                stack.pop();
            }
            stack.push(c);
        }

        char[] res = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);             // 注意这边使用的不是 pop()   栈 先进后出
        }                                      // 栈 数据结构从底向上编号    从0开始
        return new String(res);
    }
}
