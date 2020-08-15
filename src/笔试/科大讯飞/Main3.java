package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * 将一个长度为 m 的字符串左移 n 位
 * <p>
 * 输入：
 * helloworld
 * 5
 * 输出：
 * worldhello
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        int len = sb.length();
        int left = sc.nextInt();
        left = left % len;
        if (left == 0 || left == len) {
            System.out.println(sb.toString());
        } else {
            System.out.println(sb.substring(left, len) + sb.substring(0, left));
        }
    }
}
