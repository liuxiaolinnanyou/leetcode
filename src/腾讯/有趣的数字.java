package 腾讯;

import java.util.*;

/**
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 * <p>
 * 输入描述：
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N - 本组测试数据有n个数
 * a1,a2...an - 需要计算的数据
 * 保证:
 * 1<=N<=100000,0<=ai<=INT_MAX.
 * <p>
 * 输出描述：
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 * <p>
 * 输入：
 * 6
 * 45 12 45 32 5 6
 * 输出：
 * 1 2
 */
public class 有趣的数字 {
    // 先排序
    // 最大差：最大值-最小值
    // 最大差的对数：最大值的数量 * 最小值的数量
    // 取两相邻数为一对，可使差值尽可能的小。
    // 最小差：相邻的数中，差值最小的
    // 最小差的对数：
    // 1. 如果最小差为0，则为 每组相等数中 任选2个的所有 组合 数。
    // 2. 如果最小差不为0，则为 相邻数差值 = 最小差 的所有 数量。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            // 如果数组中的值全相同，直接两两组合
            if (a[0] == a[n - 1]) {
                int tmp = (n * (n - 1)) / 2;
                System.out.println(tmp + " " + tmp);
                continue;
            }
            // map 用来统计
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i]) + 1);
                else
                    map.put(a[i], 1);
            }
            // 求差最小个数
            int minres = 0;
            if (map.size() == n) {
                int min = Math.abs(a[1] - a[0]);
                for (int i = 2; i < n; i++) {
                    int tmp = Math.abs(a[i] - a[i - 1]);
                    if (tmp == min)
                        minres++;
                    else if (tmp < min) {
                        min = tmp;
                        minres = 1;
                    }
                }
            } else {
                for (Integer key : map.keySet()) {
                    int val = map.get(key);
                    if (val > 1) {
                        minres += (val * (val - 1)) / 2;
                    }
                }
            }
            // 求差最大个数
            int maxres = 0;
            List<Integer> keyset = new ArrayList<>(map.keySet());
            int val1 = map.get(keyset.get(0));
            int val2 = map.get(keyset.get(keyset.size() - 1));
            maxres = val1 * val2;
            System.out.println(minres + " " + maxres);
        }
    }
}
