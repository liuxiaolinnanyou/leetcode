package 笔试.浪潮;

import java.util.Scanner;

/**
 * 给你一个长度为n的01串。现在想要你找出最长的01交替子串（子串可以不连续）比如：1010,0101是01交替的串，1101则不是。
 * 现在你可以把某一个连续的区间进行翻转，即0变1,1变0。问修改之后的最大01交替子串的长度是多少。
 * <p>
 * 样例输入：
 * 8
 * 10000011
 * 样例输出:
 * 5
 */
public class 零一交替 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        if (count < n - 1) {
            System.out.println(count + 2);
        } else {
            System.out.println(n);
        }
    }
}