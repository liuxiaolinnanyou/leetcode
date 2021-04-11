package 笔试.字节跳动春招;
// AC 80

/**
 * 一个服务会维护两个字符串s和m，调用方会带着两个参数来请求，分别是i和j，i代表着s串的前i个字符的子串
 * j代表着m串的前j个字符的子串，需要查询这两个子串组合起来去重后有多少不同的字符。现在有t个请求。
 * <p>
 * 输入描述：
 * 首先两个字符串（长度小于等于1000，只有小写字母字符串），然后是请求次数t，表示会发起t次查询（t<=1000000）
 * 接下来t行数据，分别为i，j（i和j都是合法数字，即小于等于字符串长度）
 * 输出描述：
 * 每组数据输出t次查询的结果
 * <p>
 * 输入：
 * ab
 * ac
 * 3
 * 1 1
 * 1 2
 * 2 2
 * 输出：
 * 1
 * 2
 * 3
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String m = sc.nextLine();

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            String s1 = s.substring(0, i);
            String s2 = m.substring(0, j);
            String ss = s1 + s2;
            Set<Character> set = new HashSet<>();

            for (char c : ss.toCharArray()) {
                set.add(c);
            }
            list.add(set.size());
            n--;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}