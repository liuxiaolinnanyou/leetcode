package 达西;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最下惩罚是指对一条路径上所有边的代价执行或运算。
 */
public class 最小惩罚 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
        System.out.println(minPath(3, edges, 1, 3));
        return;
    }

    public static int res = Integer.MAX_VALUE;

    public static int minPath(int n, int[][] edges, int start, int end) {
        int roadsNum = edges.length;
        // 建立一个数组存储从某点出发可到达的点所对应的edge索引
        Map<Integer, List<Integer>> roads = new HashMap<>();
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < roadsNum; i++) {
            // 这边存的是索引，比如顶点 1 在原数组中有 0 索引 和 2 索引都含有顶点 1
            List<Integer> tmp = roads.getOrDefault(edges[i][0], new ArrayList<Integer>());
            tmp.add(i);
            roads.put(edges[i][0], tmp);
            tmp = roads.getOrDefault(edges[i][1], new ArrayList<Integer>());
            tmp.add(i);
            roads.put(edges[i][1], tmp);
        }
        used[start] = true;
        dfs(edges, roads, used, end, start, 1);
//        used[end] = false;
        return res;
    }

    public static void dfs(int[][] edges, Map<Integer, List<Integer>> roads, boolean[] used, int end, int pos, int weight) {
        if (pos == end) {
            if (weight < res) {
                res = weight;
            }
            return;
        }
        List<Integer> toGo = roads.get(pos);
        int alterWayNum = toGo.size();
        for (int i = 0; i < alterWayNum; i++) {
            int thisWayIdx = toGo.get(i);
            int nxtNode = (pos == edges[thisWayIdx][0] ? edges[thisWayIdx][1] : edges[thisWayIdx][0]);
            if (!used[nxtNode]) {
                used[nxtNode] = true;
                dfs(edges, roads, used, end, nxtNode, weight | edges[thisWayIdx][2]);
                used[nxtNode] = false;
            }
        }
        return;
    }
}
