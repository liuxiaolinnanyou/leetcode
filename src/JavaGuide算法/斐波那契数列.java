package JavaGuide算法;

/**
 * 要求输入一个整数 n ，请你输出菲波那切数列的第n项。  n<=39
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci2(5));
    }

    // 迭代
    public static int fibonacci(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int third = 0;
        for (int i = 3; i <= num; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    // 递归
    public static int fibonacci2(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci2(num - 1) + fibonacci2(num - 2);
    }
}