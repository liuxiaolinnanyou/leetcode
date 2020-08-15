package 十轮;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * <p>
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class 阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeros(3));
        System.out.println(trailingZeros(5));
    }

    // 含 5 的个数
    public static int trailingZeros(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    public static int trailingZeros2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeros2(n / 5);
    }
}
