package 八轮;

import java.util.Arrays;

/**
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * 1.如果这个数组是 [a1, a2, a3, ... , an] ，
 * 那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * 2.如果存在多种答案，你只需实现并返回其中任意一种.
 * <p>
 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
 * <p>
 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 * 解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 * <p>
 * n 和 k 满足条件 1 <= k < n <= 10^4.
 */
public class 优美的排列2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(3, 1)));
        System.out.println(Arrays.toString(constructArray(3, 2)));
    }

    // 若n=8初始状态
    // 1 2 3 4 5 6 7 8
    // k=1~~~~~~~~         | 1 2 3 4 5 6 7 8 (不翻转，直接返回)
    // k=2~~~~~~~~         1 | 8 7 6 5 4 3 2
    // k=3~~~~~~~~         1 8 | 2 3 4 5 6 7
    // k=4~~~~~~~~         1 8 2 | 7 6 5 4 3
    // 总结规律：当k>1时,需要翻转的次数为k-1次，每次翻转保留前m(m = 1,2,3...k-1)个数，每次翻转都在原数组进行。
    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;         // 产生 1 - n
        }
        if (k == 1) {
            return res;             // k == 1 直接返回
        }
        // k != 1就要翻转k - 1次，每次翻转保留前 m 个数
        for (int m = 1; m < k; m++) {
            reverse(res, m, n - 1);
        }
        return res;
    }

    // 翻转数组[i,j]之间的数
    private static void reverse(int[] res, int i, int j) {
        while (i < j) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
    }
}
