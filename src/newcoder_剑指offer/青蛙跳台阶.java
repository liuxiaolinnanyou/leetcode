package newcoder_剑指offer;

// 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
// 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class 青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(12));
        System.out.println(jumpFloor2(12));
    }

    // 方法 1        迭代
    public static int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= target; i++) {
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }


    // 方法 2    递归
    public static int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
