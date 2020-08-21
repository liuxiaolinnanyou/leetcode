package 十轮;

/**
 * 求出大于或等于 N 的最小回文素数。
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 * 例如，2，3，5，7，11 以及 13 是素数。
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 * 例如，12321 是回文数。
 * <p>
 * 输入：6
 * 输出：7
 * <p>
 * 输入：8
 * 输出：11
 * <p>
 * 输入：13
 * 输出：101
 * <p>
 * 提示：
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 */
public class 回文素数 {
    public static void main(String[] args) {
        System.out.println(primePalindrome(6));
        System.out.println(primePalindrome(8));
        System.out.println(primePalindrome(13));
    }

    // 暴力循环无法通过
    // 大家可以想象在 10-100 内的回文数，必定是 11,22,33,44,55,66,77,88,99。发现了吗？除了11以外全不是素数。
    // 同理，1000-10000之间，回文数是1111,2112,...,2222,3333,3443,...,4444,5555,6666,7777,8888,9999。
    // 相信大家已经发现了，当数字大于 11 的数的数字个数为偶数时，其回文数都不是素数，
    // 我们可以直接跳过这些数字，因为 11 必定是其质因数。
    public static int primePalindrome(int N) {
        int[] check = {2, 2, 2, 3, 5, 5, 7, 7, 11, 11, 11, 11};
        if (N < check.length && check[N] > 0) {
            return check[N];
        }
        for (; ; ) {
            int mod = N % 6;
            String cs = String.valueOf(N);
            // 新增了一个判断，用于跳过数字长度为偶数的区间
            if ((cs.length() & 1) == 0) {
                N = (int) Math.pow(10, cs.length()) + 1;
                continue;
            }
            // 原代码
            if ((mod == 1 || mod == 5)) {
                boolean isPrime = true, isPalindrome = true;
                for (int i = 5, j = 0,
                     L1 = (int) Math.sqrt(N),
                     strLen = cs.length(),
                     L2 = strLen >> 1;
                     i <= L1 || j < L2;
                     i += 6, ++j) {
                    if (i <= L1 && (N % i == 0 || N % (i + 2) == 0)) {
                        isPrime = false;
                        break;
                    }
                    if (j < L2 && cs.charAt(j) != cs.charAt(strLen - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPrime && isPalindrome) {
                    return N;
                }
                N = mod == 1 ? N + 4 : N + 2;
            } else {
                N = mod == 0 ? N + 1 : N + (5 - mod);
            }
        }
    }
}
