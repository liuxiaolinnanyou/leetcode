package 笔试.趋势科技;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给定一个用字符串表示的m位非负整数N，去掉其中的x位数字后，使得剩下的数字Y最小。
 * 注意：
 * m>=x
 * N不会包含前导0，即首位一定是非0数字
 * <p>
 * 输入：1432319   3
 * 输出：1219
 * <p>
 * 输入：2020     1
 * 输出：20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = sc.nextInt();
        System.out.println(getMin(str, count));
    }

    public static String getMin(String str, int count) {
        char[] chs = str.toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        for (char ch : chs) {
            while (!list.isEmpty() && list.peekLast() > ch - '0' && count > 0) {
                list.removeLast();
                count--;
            }
            list.add(ch - '0');
        }
        while (count > 0) {
            list.removeLast();
            count--;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int n : list) {
            if (flag && n == 0) {
                continue;
            }
            flag = false;
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}