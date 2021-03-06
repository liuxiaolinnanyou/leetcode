package 笔试.爱奇艺;

import java.util.Scanner;

/**
 * 计算 n 的阶乘中尾部所包含零的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(trailingZeros(sc.nextInt()));
        }
    }


    public static int trailingZeros(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}