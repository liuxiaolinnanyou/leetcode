package 华为;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * <p>
 * 输入描述:
 * 输入一个int型整数
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 输入：9876673
 * 输出：37689
 */
public class Hw09_提取不重复的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(solution(num));
            System.out.println(solution2(num));
        }
    }

    // 自己实现
    public static int solution(int num) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        while (num > 0) {
            int temp = num % 10;
            if (set.add(temp)) {
                ans = ans * 10 + temp;
            }
            num /= 10;
        }
        return ans;
    }

    // 另一种写法
    public static int solution2(int num) {
        char[] chars = (num + "").toCharArray();
        String str = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!str.contains(chars[i] + "")) {
                str += chars[i];
            }
        }
        return Integer.valueOf(str);
    }
}