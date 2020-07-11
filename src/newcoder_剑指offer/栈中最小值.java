package newcoder_剑指offer;

import java.util.Stack;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
// 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
public class 栈中最小值 {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Integer minElement = Integer.MAX_VALUE;

    public void push(int node) {
        if (stack.empty()) {
            minElement = node;
            stack.push(node);
        } else {
            if (node <= minElement) {
                stack.push(minElement);     // 在push更小的值时需要保留在此值之前的最小值
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        // 增加最后一个元素以及栈为空时候的检测
        if (stack.size() == 0) {
            return;
        }
        if (minElement == stack.peek()) {
            if (stack.size() > 1) {
                stack.pop();
                minElement = stack.peek();
            } else {
                minElement = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }


    public int top() {
        return stack.peek();
    }


    public int min() {
        return minElement;
    }
}
