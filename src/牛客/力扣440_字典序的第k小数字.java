package 牛客;

/**
 * @author Lxl
 * @version 1.0
 * @date 2020/6/18 10:34
 */

/**
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 注意：1 ≤ k ≤ n ≤ 109。
 * <p>
 * 输入：n：13  k：2
 * 输出：10
 * <p>
 * 解释：字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */
public class 力扣440_字典序的第k小数字 {
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }

    public static int findKthNumber(int n, int k) {
        int prefix = 1;
        int count = 1;
        while (count < k) {
            int curCount = count(prefix, n);
            if (curCount + count > k) {
                prefix *= 10;
                count++;
            } else {
                prefix++;
                count += curCount;
            }
        }
        return prefix;
    }

    private static int count(long prefix, int n) {
        long nextPrefix = prefix + 1;
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return count;
    }
}
