package 华为;

import java.util.Scanner;

/**
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。
 * 例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 * <p>
 * 输入描述:
 * int型整数
 * <p>
 * 输出描述:
 * n以内自守数的数量
 * <p>
 * 输入：2000
 * 输出：8
 */
public class Hw99_自守数 {
    // 规律：个位数为 0、1、5、6 的数才可能是自守数，故采用筛选法，只判断符合该条件的数
    // 思路1：可以把整数（数及其平方）转换为字符串，通过比较长字符串的末尾是否与短字符串相同即可
    // 如：25 * 25 = 625，字符串'625'的末尾'25'与字符串'25'的相同
    // 思路2：若该数的平方与该数的差，去模该数对应的各个进制位均等于零，则该数为自守数
    // 如：25 * 25 = 625，625 - 25 = 600，600 % (10*1) = 0，600 % （10 * 2） = 0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(calcAutomorphicNumbers(number));
        System.out.println(calcAutomorphicNumbers2(number));
        System.out.println(calcAutomorphicNumbers3(number));
//        System.out.println(Math.pow(2, 3));              // double
//        System.out.println((int) Math.pow(2, 3));        // int
    }

    // 正则表达式
    public static int calcAutomorphicNumbers(int n) {
        int num = 0;
        // ^:从字符串开头进行匹配
        // $:从字符串末尾进行匹配
        for (int i = 0; i <= n; i++) {
            if (((int) Math.pow(i, 2) + "").matches("[0-9]*" + i + "$")) {
                num++;
            }
        }
        return num;
    }

    public static int calcAutomorphicNumbers2(int n) {
        int num = 0;
        for (int i = 0; i <= n; i++) {
            if (String.valueOf((int) Math.pow(i, 2)).endsWith(String.valueOf(i))) {
                num++;
            }
        }
        return num;
    }

    public static int calcAutomorphicNumbers3(int n) {
        int num = 0;
        for (int i = 0; i <= n; i++) {
            if ((i % 10 == 0) || (i % 10 == 1) || (i % 10 == 5) || (i % 10 == 6)) {
                if (String.valueOf((int) Math.pow(i, 2)).endsWith(String.valueOf(i))) {
                    num++;
                }
            }
        }
        return num;
    }
}