package 栈;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class 最小栈 {
    /**
     * initialize your data structure here.
     */
    // 使用两个栈：一个栈去保存正常的入栈出栈的值，另一个栈去存最小值，
    // 也就是用栈顶保存当前所有元素的最小值。存最小值的栈的具体操作流程如下：
    // 将第一个元素入栈。
    // 新加入的元素如果大于栈顶元素，那么新加入的元素就不处理。
    // 新加入的元素如果小于等于栈顶元素，那么就将新元素入栈。
    // 出栈元素不等于栈顶元素，不操作。
    // 出栈元素等于栈顶元素，那么就将栈顶元素出栈。

    // 方法2：用一个变量去保存最小值（使用一个栈实现）
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public 最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            // 小于的时候才入栈
            if (x <= top) {
                minStack.push(x);
            }
        } else {
            // minStack 为空    直接压栈
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        int top = minStack.peek();
        // 等于的时候再出栈
        if (pop == top) {
            minStack.pop();
        }
    }

    public int top() {
        // 直接调用原方法
        return stack.peek();
    }

    public int getMin() {
        // 直接调用原方法
        return minStack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */