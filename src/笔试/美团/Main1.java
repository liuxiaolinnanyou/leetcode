package 笔试.美团;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 逆序数
 */
public class Main1 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (solution(i)) {
                count++;
                array.add(i);
            }
        }
        System.out.println(count);
        for (int num : array) {
            System.out.println(num + " " + num * 4);
        }
    }

    public static boolean solution(int n) {
        int sum = 0;
        int nn = 4 * n;
        while (n != 0) {
            sum = sum * 10 + n % 10;
            n = n / 10;
        }
        return sum == nn;
    }
}
