package newcoder_剑指offer;

import java.util.Stack;

// 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
public class 两个栈实现队列 {
    public static void main(String[] args) {

    }
}


class Solution<stack> {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // 压栈
    public void push(int node) {
        stack1.push(node);
    }

    // 出栈
    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}