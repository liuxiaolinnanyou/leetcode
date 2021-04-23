package 十二轮;

public class 使用数组实现栈 {
    // 存数据的数组
    int[] stack;

    // 栈的最大长度
    private int size;
    // 栈顶的位置
    private int top;

    public 使用数组实现栈(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public int getSize() {
        return size;
    }

    public int getTop() {
        return top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top + 1) == size;
    }

    public boolean push(int data) {
        if (isFull()) {
            System.out.println("栈中元素已满！");
            return false;
        } else {
            top++;
            this.stack[top] = data;
            return true;
        }
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("栈为空！");
        } else {
            return this.stack[top--];
        }
    }

    public int peek() {
        return this.stack[getTop()];
    }

    public static void main(String[] args) {
        使用数组实现栈 stack = new 使用数组实现栈(20);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("现在栈顶的元素是：" + stack.peek());

        while (!stack.isEmpty()) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}