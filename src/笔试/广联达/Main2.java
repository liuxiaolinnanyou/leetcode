package 笔试.广联达;

import java.util.Scanner;

/**
 * 你购买了一个机器人，他现在剩下C单位电量，你现在想让他做一些动作愉悦自己，他可以做n种动作，每种动作最多做一次，因为你觉得让
 * 机器人重复做一种动作是无聊的。每种动作都有一个固定电量花费Ci单位电量，以及这个动作的愉悦度Wi，请你在电量范围内让他做出
 * 让你最愉悦的动作，即做出的动作的总电量消耗不能超过C，并使愉悦度之和最大。(电量在开始动作前就要扣除，若电量不足则无法做出动作。)
 * <p>
 * 输入：
 * 3 15    动作数量  剩余电量
 * 5.00 16
 * 9.00 1
 * 8.00 15
 * <p>
 * 输出：
 * 31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // 动作数
        double C = sc.nextDouble();    // 剩余电量
        int CInt = (int) (C * 100);    // 转成 int 类型
        double[] cost = new double[n]; // 动作花费的电量
        int[] costInt = new int[n];    // 电量对应的 int
        int[] joy = new int[n];        // 愉悦值

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextDouble();
            costInt[i] = (int) (cost[i] * 100);
            joy[i] = sc.nextInt();
        }

        int lN = (int) ((C + 1) * 100);
        int[] res = new int[lN];

        for (int i = 0; i < n; i++) {
            int tmp = costInt[i];
            for (int j = lN - 1; j >= tmp; j--) {
                if (joy[i] + res[j - tmp] > res[j]) {
                    res[j] = joy[i] + res[j - tmp];
                }
            }
        }
//        System.out.println(Arrays.toString(res));
        System.out.println(res[lN - 101]);
        return;
    }
}