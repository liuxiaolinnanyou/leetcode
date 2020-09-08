package LeetCode_二分查找;

/*
69.x的平方根
    实现 int sqrt(int x) 函数。
    计算并返回 x 的平方根，其中 x 是非负整数。
    由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

输入4    输出2
输入8    输出2( 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。)
 */
public class x的平方根 {
    public static void main(String[] args) {
        int result = mySqrt(4);
        int result2 = mySqrt(8);
        int result3 = mySqrt(0);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }


    // 二分法
    public static int mySqrt(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
//            long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }
}