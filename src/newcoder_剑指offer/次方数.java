package newcoder_剑指offer;

// 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。求 base 的 exponent 次方。
// 保证 base 和 exponent 不同时为0
public class 次方数 {
    public static void main(String[] args) {
        System.out.println(power(2.0, 3));
//        System.out.println(power(3.0, -2));
    }

    public static double power(double base, int exponent) {
//        if (base == 0) {
//            return 0;
//        }
//        boolean flag = false;
//        if (exponent < 0) {
//            flag = true;
//            exponent = -exponent;
//        }
//        double ans = 1;
//        for (int i = 1; i <= exponent; i++) {
//            ans *= base;
//        }
//        return flag ? 1 / ans : ans;


        boolean flag = false;
        if (exponent < 0) {
            flag = true;
            exponent = -exponent;
        }
        double ans = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                ans = ans * base;
            }
            exponent >>= 1;
            base *= base;
        }
        return flag ? 1 / ans : ans;
    }
}
