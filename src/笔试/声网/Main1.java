package 笔试.声网;

import java.util.Scanner;

/**
 * 第一个只出现一次的字符
 * <p>
 * 输入：abaccdeff
 * 输出：b
 * <p>
 * 输入：adsghaehfsaf32r1241
 * 输出：d
 */
// 开始使用String类的indexOf()   只通过 40
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null || s.length() == 0) {
            System.out.println('\0');    // 输出空字符
            return;
        }

        char[] chars = s.toCharArray();
        int[] arr = new int[256];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i]] == 1) {
                System.out.println(chars[i]);
                return;
            }
        }
        System.out.println('\0');
        return;
    }
}