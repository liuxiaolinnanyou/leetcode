package 笔试.去哪儿网;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 求组合数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(combine(m, n));
    }

    static Map<String, Long> map = new HashMap<>();

    public static long combine(int m, int n) {
        String key = m + "," + n;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return m;
        }
        if (n > m / 2) {
            return combine(m, m - n);
        }
        if (n > 1) {
            if (!map.containsKey(key)) {
                map.put(key, combine(m - 1, n - 1) + combine(m - 1, n));
            }
            return map.get(key);
        }
        return -1;
    }
}