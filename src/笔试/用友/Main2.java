package 笔试.用友;

import java.util.Arrays;

/**
 * 最便宜的价格列表
 * <p>
 * 有n个城市通过m个航班连接，每个航班都从城市u开始，以价格w抵达v，
 * 现在给定所有的城市和航班，以及出发城市src，你的任务是找到从src
 * 出发到其他所有城市最便宜的机票价格列表。
 * 假设两个城市之间机票价格不会超过Integer.MAX_VALUE，如果无法从src
 * 到达某个城市，则他们的价格用-1表示。
 * <p>
 * 输入：
 * n=3， edges=[[0,1,100],[1,2,100],[0,2,500]],src=0
 * 输出：
 * [0,100,200]
 * <p>
 * 输入：
 * n=3， edges=[[0,1,100],[1,2,100],[0,2,500]],src=1
 * 输出：
 * [-1,0,100]
 */
public class Main2 {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(Arrays.toString(findAllCheapestPrice(3, arr, 0)));
//        System.out.println(Arrays.toString(findAllCheapestPrice(3, arr, 1)));
    }

    public static int[] findAllCheapestPrice(int n, int[][] flights, int src) {
        // 建立价格表，对价格中未走过的的最小地点进行松弛，更新到每个地点的价格。
        int[] fee = new int[n];
        Arrays.fill(fee, Integer.MAX_VALUE);
        fee[src] = 0;
        boolean[] marked = new boolean[n];
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < flights.length; i++) {
            cost[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        for (int i = 0; i < n; i++) {
            int minFee = Integer.MAX_VALUE;
            int minPos = -1;
            for (int j = 0; j < n; j++) {
                if (!marked[j] && fee[j] < minFee) {
                    minFee = fee[j];
                    minPos = j;
                }
            }
            if (minPos == -1) {
                continue;
            }
            marked[minPos] = true;
            for (int j = 0; j < n; j++) {
                if (cost[minPos][j] != Integer.MAX_VALUE && cost[minPos][j] + fee[minPos] < fee[j]) {
                    fee[j] = cost[minPos][j] + fee[minPos];
                }
            }
        }
        // 无法到达的使用 -1 表示
        for (int i = 0; i < n; i++) {
            if (fee[i] == Integer.MAX_VALUE) {
                fee[i] = -1;
            }
        }
        return fee;
    }
}