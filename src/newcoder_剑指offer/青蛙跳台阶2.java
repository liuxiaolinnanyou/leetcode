package newcoder_剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 青蛙跳台阶2 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(2));
    }

    // f(n)=2f(n-1)
    public static int jumpFloor(int target) {
        return 1 << (target - 1);
        // return Math.pow(2, target - 1);
    }
}
