package 达西;

import java.util.*;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * <p>
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class 节点间通路 {
    public static void main(String[] args) {
        int[][] graph1 = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        int[][] graph2 = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println(findWhetherExistsPath(3, graph1, 0, 2));
        System.out.println(findWhetherExistsPath(5, graph2, 0, 4));
    }

    // 主要思路是先转邻接表，然后遍历方法用深度和广度应该都可以。
    // 理论上，首先要理解图，其次理解有向图。
    // 题中graph, [0,1]这种数组表示一条从0到1的有向边，多个有向边连成整个有向图。
    // 数据结构上，有向图使用邻接表存储的。所以这里把有向图转为链表处理。

    // 1）维护一个队列：从0的链表访问，访问过程中0能到达的节点继续入栈
    // 2）维护一个数组：对已经入列的节点，不再重复处理
    // 3）不断从队列中取节点得到新的可访问链表，对链表上的可访问节点中判断是否有target
    // 4）遍历过程中有target则直接返回true, 否则返回false
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 将矩阵转为邻接表
        List<Integer>[] adj = new ArrayList[n];   // 建一个数组，存的是List<Integer>
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            if (adj[from] == null) {
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);     // 图中的一个点可以到任意多个其他点
        }
        // 建一个函数进行广度遍历
        return hasPath(n, adj, start, target);
    }

    private static boolean hasPath(int n, List<Integer>[] adj, int start, int target) {
        // 维护一个队列：从0的链表访问，访问过程中0能到达的节点继续入列
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        // 维护一个数组：对已经入列的节点，不再重复处理
        boolean[] visited = new boolean[n];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 不断从队列中取节点得到新的可访问链表，对链表上的可访问节点中判断是否有target
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if (nextList == null) {
                    continue;
                }
                for (Integer next : nextList) {
                    // 遍历过程中有target则直接返回true, 否则最终返回false
                    if (next == target) {
                        return true;
                    }
                    // 已经入列的节点，不再重复处理
                    if (visited[next]) {
                        continue;
                    }
                    // 用数组标记新的节点
                    visited[next] = true;
                    // 访问过程中0能到达的节点继续入列
                    queue.add(next);
                }
            }
        }
        return false;
    }


    // 方法 2
    public static boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (map.containsKey(graph[i][0])) {
                map.get(graph[i][0]).add(graph[i][1]);
            } else {
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(graph[i][1]);
                map.put(graph[i][0], set);
            }
        }
        Set<Integer> set = map.get(start);
        if (set == null || set.isEmpty()) {
            return false;
        }
        return funFound(map, start, target);
    }

    public static boolean funFound(Map<Integer, Set<Integer>> map, int start, int target) {
        if (start == target) {
            return true;
        }
        Set<Integer> set = map.get(start);
        if (set == null || set.isEmpty()) {
            return false;
        }
        for (Integer i : set) {
            if (funFound(map, i, target)) {
                return true;
            }
        }
        return false;
    }
}
