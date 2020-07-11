package newcoder_剑指offer;

public class 青蛙跳台阶2 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(2));
    }

    public static int jumpFloor(int target) {
        return 1 << (target - 1);
        // return Math.pow(2, target - 1);
    }
}
