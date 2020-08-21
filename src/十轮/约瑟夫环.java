package 十轮;

import java.util.Scanner;

/**
 * 有n个人围成一圈，从第一个人开始一次报数，
 * 每报到 m 时，报数为 m 的人退出，求最后剩下的人是多少号
 */
public class 约瑟夫环 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入参与游戏的人数：n=");
        int n = sc.nextInt();
        System.out.println("请输入每隔多少人退出一个人，m=");
        int m = sc.nextInt();
        int count = 0;             // 定义一个计数器
        int[] a = new int[n];
        int length = n;            // 定义数组的长度
        int i = 0;
        for (; i < n; i++) {
            a[i] = 0;              // 定义一个数组，初始值都为零
        }
        i = 0;
        while (length > 1) {
            if (a[i] == 0) {      // 当数组值为零时，计数器增加1
                count++;
            }
            if (count == m) {     // 当计数器等于设定值时，
                a[i] = 1;         // 将数组中该位置的值改为1
                count = 0;
                length--;         // 数组的长度减少1个值
            }
            i++;
            if (i == n) {         // 当i到达最大值时，让数组从头开始
                i = 0;
            }
        }
        for (i = 0; i < n; i++) {
            if (a[i] == 0) {      // 最后数组中剩下的为1的值，即为最后剩下的那个人
                System.out.println("最后剩下的人是第" + (i + 1) + "个人");
            }
        }
    }
}