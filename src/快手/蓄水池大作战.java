package 快手;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 在你面前有n个蓄水池，他们组成了树形结构（由n-1条边连接）。蓄水池节点编号从1开始到n。对每个蓄水池节点来说，
 * 他的儿子蓄水池节点都摆放在他的下面，并且和它用水管相连，根据重力，水会向下流动。现在我们要在蓄水池上做一些操作：
 * 1. 把节点v填满水。然后v的所有儿子节点水也会被填满
 * 2. 清空节点v的水。然后v所有的父亲节点水都会被清空
 * 3. 询问每个蓄水池节点是否有水。
 * 初始状态时候，每个节点都是空的。
 * 现在我们会依次进行一系列操作，我们想提前知道每次操作后的结果，你能帮忙解决吗？
 * <p>
 * 输入描述：
 * 第一行包含一个正整数n(1<=n<=1000)，表示蓄水池节点的数量。
 * 后面n-1行，每行有两个数字a[i], b[i]。（1<=a[i], b[i]<= n, a[i]!=b[i])表示蓄水池的连接关系。
 * 接下来的一行包含一个整数q(1<=q<=1000)，表示我们要进行的操作的数量。
 * 最后的q行中，每行包含两个数字c[i] (1<=c[i]<=3)和v[i](1<=v[i]<=n)。其中c[i]表示操作类型(1,2或者3)。v[i]表示操作对应的蓄水池节点。
 * 输入数据保证合理，是一个连通的树。
 * 输出描述：
 * 对于每个操作3（c[i] == 3)，输出一个数字1或者0。1表示v[i]蓄水池节点有水，0表示没水。
 * <p>
 * 输入：
 * 5
 * 1 2
 * 5 1
 * 2 3
 * 4 2
 * 12
 * 1 1
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 * 3 4
 * 1 2
 * 2 4
 * 3 1
 * 3 3
 * 3 4
 * 3 5
 * 输出：
 * 0
 * 0
 * 0
 * 1
 * 0
 * 1
 * 0
 * 1
 */
public class 蓄水池大作战 {
    static HashSet<Integer>[] adj;
    static boolean[] full;

    // 先创建HashSet数组建图，创建full数组表示当前节点是否有水，在根据条件进行充水或者清水
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        adj = new HashSet[n + 1];
        full = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        int q = scanner.nextInt();
        while (q-- > 0) {
            int method = scanner.nextInt(), v = scanner.nextInt();
            switch (method) {
                case 1:
                    flood(v);
                    break;
                case 2:
                    clear(v);
                    break;
                case 3:
                    System.out.println(full[v] == true ? 1 : 0);
                    break;
            }
        }
    }

    private static void clear(int v) {
        full[v] = false;
        for (int w : adj[v]) {
            if (w < v) {
                clear(w);
            }
        }
    }

    private static void flood(int v) {
        full[v] = true;
        for (int w : adj[v]) {
            if (w > v) {
                flood(w);
            }
        }
    }
}
