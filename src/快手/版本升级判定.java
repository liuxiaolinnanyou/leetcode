package 快手;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定两个版本号，只有在版本号更高的时候，才可以升级。「.」号作为分割符使用，版本号中只有数和.号。
 * 例如：0.1<1.1
 * 1.2<13.37
 * <p>
 * 输入描述：
 * 第一行为m(1<=m<=100000)，表示测试组数，接下来m行，表示m次查询。
 * 每行两个版本号，空格分隔。一个版本号中最多只会出现3个「.」。每个版本号中数字1<=x<=100。
 * 输出描述：
 * 对于每一次查询，输出是否可以升级，是则输出"true"，否则输出"false" (引号不要输出)
 * <p>
 * 输入1：
 * 2
 * 6.6.6 6.6.7
 * 1 1.0
 * 输出1：
 * true
 * false
 * 说明：1和1.0被认为是相同的版本号
 * <p>
 * 输入2：
 * 1
 * 1 1.0.0.2
 * 输出2：
 * true
 */
public class 版本升级判定 {
    public static void main(String[] args) {
//        String s = "1.0.0.2";
//        System.out.println(s.length());
//        String[] split = s.split(".");
//        String[] split1 = s.split("\\.");
//        System.out.println(Arrays.toString(split));
//        System.out.println(Arrays.toString(split1));

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(update(s1, s2));
        }
    }

    public static boolean update(String s1, String s2) {
        String[] str1 = s1.split("\\.");
        String[] str2 = s2.split("\\.");
        int length = Math.max(s1.length(), s2.length());
        // 定义两个数组保存扩充后的数组
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        // 为了方便循环比较大小，将字符串切割成的数组扩充为相等长度
        for (int i = 0; i < length; i++) {
            if (i < str1.length) {
                arr1[i] = Integer.parseInt(str1[i]);
            } else {
                arr1[i] = 0;
            }
            if (i < str2.length) {
                arr2[i] = Integer.parseInt(str2[i]);
            } else {
                arr2[i] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            if (arr1[i] > arr2[i]) {
                return false;
            } else if (arr1[i] < arr2[i]) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}
