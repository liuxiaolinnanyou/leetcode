package 牛客;

import java.util.Scanner;

/**
 * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
 * 1+2*3=7
 * 1*(2+3)=5
 * 1*2*3=6
 * (1+2)*3=9
 * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
 * <p>
 * 输入描述：一行三个数a，b，c (1 <= a, b, c <= 10)
 * 输出描述：能够获得的最大值
 * <p>
 * 输入：1 2 3    输出：9
 */
public class 表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[3];
//        arr[0] = sc.nextInt();
//        arr[1] = sc.nextInt();
//        arr[2] = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count = 0;
        if (a * b > a + b) {       // 先判断a+b和a*b哪个更大,取大者进行运算
            count = a * b;
        } else {
            count = a + b;
        }
        if (c > 1) {               // c小于1就相加,c大于1就相乘
            System.out.println(count * c);
        } else {
            System.out.println(count + c);
        }
    }
}