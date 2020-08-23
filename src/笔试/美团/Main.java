package 笔试.美团;

import java.util.Scanner;

/**
 * 输入：
 * 6
 * beijing nanjing
 * nanjing guangzhou
 * guangzhou shanghai
 * shanghai beijing
 * fuzhou beijing
 * beijing fuzhou
 * <p>
 * 输出：
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        String begin = null;
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            if (begin == null) {
                begin = strings[0];
            }
            if (strings[1].equals(begin)) {
                count++;
                begin = null;
            }
        }
        System.out.println(count);
    }
}