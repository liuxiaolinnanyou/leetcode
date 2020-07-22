package 二轮;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class Pow {
    public static void main(String[] args) {

    }

    // 自己写的      超出时间限制
//    public static double myPow(double x, int n) {
//        boolean flag = false;
//        if (n == 0) {
//            return 1.0;
//        }
//        if (n > 0) {
//            flag = true;
//        }
//        if (n < 0) {
//            n = -n;
//        }
//        double ans = 1.0;
//        for (int i = 1; i <= n; i++) {
//            ans = ans * x;
//        }
//        return flag ? ans : 1 / ans;
//    }


    // 快速幂
    public static double myPow(double x, int n) {
        long N = n;       // 解决在最小值处可能出现的问题
        // Java 代码中 int32 变量 n∈[−2147483648,2147483647] ，因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 N ，后面用 N 操作即可。
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private static double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
