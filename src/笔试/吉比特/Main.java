package 笔试.吉比特;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一个由英文字母组成的字符串，假定字符 c1 和 字符 c2 在字符串中的位置分别为 p1 和 p2，求 p1 和 p2 差的绝对值的最大值。
 *
 * 输入只有一行，依次为一个由英文字母组成的字符串、字符1和字符2
 * 字符串长度不超过64 ，字母不区分大小写
 *
 * 输出一个整数，为字符最大距离，如果给定字符不在字符串中，则输出 -1 即可。
 *
 * 输入：
 * ba A b
 * 输出：
 * 1
 */

// AC 90
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String str = split[0].toLowerCase();
            char c1 = Character.toLowerCase(split[1].toCharArray()[0]);
            char c2 = Character.toLowerCase(split[2].toCharArray()[0]);

            if (c1 == c2) {
                System.out.println(0);
                return;
            }else if (!str.contains("" + c1) || !str.contains("" + c2)) {
                System.out.println(-1);
                return;
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == c1) {
                    list1.add(i);
                }
                if (str.charAt(i) == c2) {
                    list2.add(i);
                }
            }
            System.out.println(Math.abs(list1.get(0) - list2.get(list2.size() - 1)));
        }
    }
}
