package newcoder_剑指offer;

/**
 * 第64题
 */
public class 求n的累加和 {
    public static void main(String[] args) {
        System.out.println(solve(6));
    }

    private static int solve(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += solve(n - 1)) > 0);
        return sum;
    }
}