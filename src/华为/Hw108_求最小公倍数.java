package 华为;

import java.util.Scanner;

/**
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 输入描述:
 * 输入两个正整数A和B。
 * 输出描述:
 * 输出A和B的最小公倍数。
 * <p>
 * 输入：5 7
 * 输出：35
 */
public class Hw108_求最小公倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(methods(a, b));
        System.out.println("----------------");
        System.out.println(a * b / methods(a, b));   // 最小公倍数=两数相乘/最大公约数
    }

    // 求最大公约数
    public static int methods(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1 > num2) {
            int differ = num1 - num2;
            return methods(num2, differ);
        } else {
            int differ = num2 - num1;
            return methods(num1, differ);
        }
    }

    // 自己写
    public static int methods2(int num1, int num2) {
        int start = num1 < num2 ? num2 : num1;
        int res = 0;
        for (int i = start; i <= num1 * num2; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}
