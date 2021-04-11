package 笔试.字节跳动春招;

// AC 100
/**
 * 破译
 * 1.字母仅包含大写字母，每个字母（A-Z），都可能会表示另一个字母
 * 2.每个数字（0-9），都可能会表示另一个数字
 * 3.除了数字与字母以外的字符，不会发生变化
 * <p>
 * 破译与情报的第一个字符x密切相关
 * 1.若x为字母，则情报中的所有字母和数字均按照字母表顺序往后x位
 * 2.若x为数字，则情报中的所有字母和数字均按照字母表顺序往后x位
 * 3.若x为其他字符，则与x为A等价
 * <p>
 * 如果在替换字母的过程中，向后移动x位，超过了字母Z，则会回到A开始计算。
 * 如果在替换数字的过程中，向后移动x位，超过了字母9，则会回到0开始计算。
 * <p>
 * 输入：
 * Lx.91
 * 输出：
 * XJ.13
 * <p>
 * 输入：
 * %123
 * 输出：
 * %234
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        char ch;
        int x;
        if (Character.isLetter(s.charAt(0))) {
            ch = s.charAt(0);
            x = ch - 'A' + 1;
        } else if (Character.isDigit(s.charAt(0))) {
            ch = s.charAt(0);
            x = ch - '0';
        } else {
            x = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                int add = s.charAt(i) + x;
                if (Character.isLetter(s.charAt(i))) {
                    if (add >= 65 && add <= 90) {
                        sb.append((char) (s.charAt(i) + x));
                    } else {
                        sb.append((char) (s.charAt(i) + x - 26));
                    }
                } else {
                    if (add >= 48 && add <= 57) {
                        sb.append((char) (s.charAt(i) + x));
                    } else {
                        sb.append((char) ((Integer.parseInt("" + s.charAt(i)) + x) % 10 + 48));
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}