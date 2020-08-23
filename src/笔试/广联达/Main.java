package 笔试.广联达;

import java.util.Scanner;

/**
 * 有一个跳舞机，用WSAD四个大写字母分别表示上下左右四个方向。
 * 踩对加20分，踩错扣10分，当分数为0时不会往下继续扣分，即不会存在负分。
 * <p>
 * 输入：
 * WASDWWSAD
 * WASSWWAAD
 * 输出：
 * 120
 * <p>
 * 字符串长度小于等于2000
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int sum = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    sum += 20;
                } else {
                    if (sum > 0) {
                        sum -= 10;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}