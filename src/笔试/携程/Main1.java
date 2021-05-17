package 笔试.携程;

// 83%

// 力扣 第 1235 题
/**
 * 最大收益
 * 小A毕业后，回家继承了租车公司。现在小A的店内只剩下一辆汽车可出租，但是一天
 * 内有n个订单，每个订单的用车开始时间为第x小时，用车结束时间为第y小时，订单jine为z
 * 请你帮小A安排订单，计算小A可以获得的最大收益。
 * <p>
 * 第一行输入一个整数n，表示有n(1 <= n <= 10)个订单
 * 第二行读入用空格分隔的整数，表示订单的开始时间
 * 第三行读入用空格分隔的整数，表示订单的结束时间
 * 第四行读入用空格分隔的整数，表示订单金额。
 * <p>
 * 输入：
 * 4
 * 1 2 3 3
 * 3 4 5 6
 * 200 150 180 210
 * 输出：
 * 410
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String start = sc.nextLine();
        String end = sc.nextLine();
        String money = sc.nextLine();

        int[] startArr = new int[n];
        int[] endArr = new int[n];
        int[] moneyArr = new int[n];

        for (int i = 0; i < n; i++) {
            startArr[i] = Integer.parseInt(start.split(" ")[i]);
            endArr[i] = Integer.parseInt(end.split(" ")[i]);
            moneyArr[i] = Integer.parseInt(money.split(" ")[i]);
        }
        int longHour = 0;
        int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            res[i][0] = startArr[i];
            res[i][1] = endArr[i];
            res[i][2] = moneyArr[i];
            if (endArr[i] > longHour) {
                longHour = endArr[i];
            }
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int num1 = o1[0] - o2[0];
                int num2 = num1 == 0 ? o1[1] - o2[1] : num1;
                int num3 = num2 == 0 ? o2[2] - o1[2] : num2;
                return num3;
            }
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }

        int[] ans = new int[longHour + 1];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            for (int j = res[i][1]; j < longHour + 1; j++) {
                if (j == res[i][1]) {
                    ans[j] = Math.max(Math.max(ans[j], ans[res[i][0]] + res[i][2]), ans[j - 1]);
                } else {
                    ans[j] = Math.max(ans[j], ans[j - 1]);
                }
            }
        }
//        System.out.println(Arrays.toString(ans));
        System.out.println(ans[longHour - 1]);
    }

    /**
     * 序列型dp
     * dp[i]表示到第i个所能赚到的最大金钱
     * 建立一个类保存工作的startTime,endTime,profit
     * 根据endTime从小到大排序
     * 转移:
     * if(job[j].end<=job[i].start) dp[i]=Math.max(dp[i],dp[j]+job[i].profit);
     * 没有的话,dp[i]=Math.max(dp[i-1],job[i].profit); 第i个选择第i-1个的状态或选择自己单独一个
     */
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int dp[] = new int[n + 1];
        jobs[] job = new jobs[n];
        for (int i = 0; i < n; i++) {
            job[i] = new jobs(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(job, Comparator.comparingInt(o -> o.end));
        for (int i = 0; i < n; i++) {
            dp[i] = job[i].profit;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], job[i].profit);
            for (int j = i - 1; j >= 0; j--) {
                if (job[j].end <= job[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + job[i].profit);
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}

class jobs {
    int start, end, profit;

    jobs(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }
}