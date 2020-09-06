package 笔试.招银网络科技;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 例如系统内有5个服务节点（节点编号0-4），使用5阶矩阵表达各个服务的关联关系，0 表示无访问，1 表示有访问。
 * 0 1 0 0 0
 * 0 0 1 1 0
 * 1 0 0 0 0
 * 0 0 0 0 1
 * 0 1 1 0 0
 * A[0][1] == 1 表示节点 0 会调用节点 1
 * A[4][0] == 0 表示节点 4 会调用节点 0
 * 将矩阵画出后，可以观察到，若从服务4出发，存在环。
 * 4 1 3 4
 * 4 2 0 1 3 4
 * <p>
 * 程序输入：
 * 5      服务节点的个数
 * 0 1 0 0 0 0 0 1 1 0 1 0 0 0 0 0 0 0 0 1 0 1 1 0 0    服务间的关系
 * 4      起点服务编号
 * 程序输出：
 * 413
 * 42013
 * 逐行输出环路信息。
 */
// 这道题目对比分析 达西 中的两道类似的题
public class Main {
    static boolean[] visited;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        start = sc.nextInt();
        sc.close();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nums[start][i] == 1) {
                List<Integer> path = new ArrayList<>();
                dfs(nums, n, path, i);
            }
        }
    }

    public static void dfs(int[][] nums, int n, List<Integer> path, int index) {
        if (index == start) {
            System.out.print(start);
            for (Integer i : path) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        path.add(index);
        for (int i = 0; i < n; i++) {
            if (nums[index][i] == 1) {
                dfs(nums, n, path, i);
            }
        }
        path.remove(path.size() - 1);
        visited[index] = false;
    }
}