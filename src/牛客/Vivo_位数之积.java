package 牛客;

import java.util.Stack;

/**
 * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），
 * 使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 * <p>
 * 输入 36  输出 49
 * 输入 100  输出 455
 */
public class Vivo_位数之积 {
    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(solution(36));
        System.out.println(solution(100));
        System.out.println("-------------------------");
        System.out.println(solution2(9));
        System.out.println(solution2(36));
        System.out.println(solution2(100));
    }

    /**
     * 关键思想就是要从大到小遍历，因为要保证输出的位数越少越好，所以用越大的因子会用越少的位数除完，
     * 而相同的位数内，高位的数字越大，低位的就越小，倒序输出时的数就越小。
     */
    // 方法 1
    public static int solution(int n) {
        if (n < 10) {
            return 10 + n;
        }
        int res = 0;
        int base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * base;
                base *= 10;
                n /= i;
            }
        }
        if (n > 1) {
            return -1;
        } else {
            return res;
        }
    }

    // 方法 2
    // 使用栈实现
    public static int solution2(int n) {
        if (n < 10) {
            return n + 10;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                n = n / i;
                stack.push(i);
            }
        }
        if (n > 1) {
            return -1;
        }
        // 拼接
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
//            s.append(stack.peek());
//            stack.pop();
            s.append(stack.pop());
        }
        int res = Integer.parseInt(s.toString());
        return res;
    }
}
