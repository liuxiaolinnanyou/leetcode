package JavaGuide算法;

import java.util.Scanner;

/**
 * 一个合法的括号匹配序列有以下定义：
 * · 空串""是一个合法的括号匹配序列
 * · 如果"X"和"Y"都是合法的括号匹配序列，"XY"也是一个合法的括号匹配序列
 * · 如果"X"是一个合法的括号匹配序列，那么"(X)"也是一个合法的括号匹配序列
 * · 每个合法的括号序列都可以由以上规则生成
 * <p>
 * <p>
 * 定义它的深度：
 *      空串""的深度是0
 *      如果字符串"X"的深度是x，字符串"Y"的深度是y，那么字符串"XY"的深度为max(x,y)
 *      如果"X"的深度是x，那么字符串"(X)"的深度是x+1
 * <p>
 * 输入描述：
 * 输入一个合法的括号序列s，s的长度length(2 <= length <= 50)，序列中只包含 '(' 和 ')'
 * 输出描述：
 * 输出一个正整数，即这个序列的深度
 */
public class 括号匹配深度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(depth(s));
    }

    // 从第一个字符开始向后遍历，碰到 '(' ，count + 1 ，否则count - 1。用max保存，max = Math.max(max,count)
    // max是上次循环的保存的最大值
    public static int depth(String s) {
        int cnt = 0;
        int max = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
