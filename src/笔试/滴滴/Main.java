package 笔试.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A+B问题：
 * 设a，b，c是 0 到 9 之间的整数，（其中a，b，c互不相同），其中 abc 和 acc 是两个不同的三位数，现给定一个正整数 n ，问有多少对
 * abc 和 acc 能满足 abc + acc = n（a！=0）？
 * <p>
 * 输入：
 * 一个正整数n    100 < n < 2000
 * 输出：
 * 第一行输出有多少对满足要求的数字。
 * 接下来每一行输出一对abc和acc，以空格分隔，如果没有一对abc和acc的话，则直接输出0即可。
 * 如果有多对，请按照abc升序的次序输出。
 * <p>
 * 输入：1068
 * 输出：
 * 1
 * 524 544
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int av = n / 200;
//        List<String> res = new LinkedList<>();
//        for (int a = av - 1; a < av + 1; a++) {
//            for (int b = 0; b < 10; b++) {
//                for (int c = 0; c < 10; c++) {
//                    if (200 * a + 10 * b + 12 * c == n && a != 0 && a != b && a != c && b != c) {
//                        String s = " " + a + b + c + " " + a + c + c;
//                        s = s.substring(1);
//                        res.add(s);
//                    }
//                }
//            }
//        }
//        System.out.println(res.size());
//        Collections.sort(res);
//        for (String s : res) {
//            System.out.println(s);
//        }

        List<String> list = new ArrayList<>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (a * 200 + b * 10 + c * 12 == n && a != b && a != c && b != c) {
                        String s = "" + a + b + c + " " + a + c + c;
                        list.add(s);
                    }
                }
            }
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}