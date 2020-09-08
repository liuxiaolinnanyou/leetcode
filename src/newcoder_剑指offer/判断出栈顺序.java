package newcoder_剑指offer;

import java.util.Stack;

// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
// 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
public class 判断出栈顺序 {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop));
        System.out.println(isPopOrder(push, pop2));
    }

    public static boolean isPopOrder(int[] pushA, int[] popA) {
        // 新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，
        // 当循环结束时，判断栈是否为空，若为空则返回true
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {     // 当栈不为空时
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}