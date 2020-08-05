package 六轮;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class 计数质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    // 主要采用了排除法：
    // 1、比2大的偶数肯定不是质数，排除。
    // 2、质数的倍数一定不是质数，排除。
    // 3、所以我们把【比2大的偶数】和【质数的奇数倍数】排除掉，剩下的就是质数。

    // 1、首先去掉一半的偶数，有人会问了“2也是偶数呀，是不是多排除了一个”？其实1已经代替了2被排除了。
    // 2、第一轮循环从3开始，依次把3x3,3x5,3x7,3x9......等3的奇数倍数排除。
    // 3、第二轮循环,依次把5x5,5x7,5x11,5x13......等5的奇数倍数排除，你会发现这里怎么少了一个5x9？其实5x9=3x15已经在上一轮循环被排除。
    // 4、最后循环到sqrt(n)就能排除掉所有的非质数。
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        // 首先去掉一半的偶数
        int count = n / 2;
        boolean[] isPrimes = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            // 不是质数
            if (isPrimes[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrimes[j]) {
                    count--;
                    isPrimes[j] = true;
                }
            }
        }
        return count;
    }
}