package 十一轮;

import java.util.Scanner;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 */
public class 丑数2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isUgly(num));
    }

    public static boolean isUgly(int num) {
        // 需要特判 0
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
