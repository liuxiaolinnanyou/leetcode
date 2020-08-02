package 七轮;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * <p>
 * 输入: [0,1]
 * 输出: 0
 */
public class 数字范围按位与 {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);     // 2147483647

    }

    // 暴力法      时间超时
    public static int rangeBitwiseAnd(int m, int n) {
//        int res = m;
//        for (int i = m + 1; i <= n; i++) {
//            res &= i;
//        }
//        return res;

        // m 要赋值给 i，所以提前判断一下
        if (m == Integer.MAX_VALUE) {
            return m;
        }
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
            if (res == 0 || i == Integer.MAX_VALUE) {
                break;
            }
        }
        return res;
    }

    // 数字按位与，即所有数字里，某一位上只要有一个数字里是 0，则最后结果里这一位就是 0
    // 我们需要将 m 和 n 的二进制序列划分为两部分，划分的标准为，
    // m 的左半部分和 n 的左半部分相同，m 的右半部分 和 n 的右半部分不同
    // m = 1100 0101
    // n = 1111 0011
    //     1100 0000

    // 综上，我们只需要将 m 和 n 一直右移，直到出现 m == n，即 留下 左半部分，将右半部分全部右移走
    // 同时，我们需要记录右移的次数，即右半部分的位数，然后再最后通过补 0 将右半部分的位数给补回来
    public static int rangeBitwiseAnd2(int m, int n) {
        int count = 0;
        while (n != m) {
            n >>= 1;
            m >>= 1;
            count++;
        }
        return m << count;
    }
}