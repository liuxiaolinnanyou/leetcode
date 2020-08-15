package 笔试.美团;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!map.keySet().contains(a)) {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            } else
                map.get(a).add(b);
            if (!map.keySet().contains(b)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(a);
                map.put(b, list1);
            } else
                map.get(b).add(a);
        }
        int[] visted = new int[n + 1];
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visted[i] == 0) {
                res += 1;
                dfs(map, visted, i, i);
            }
        }
        System.out.println(res);
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            int a = visted[i];
            if (!map2.keySet().contains(a)) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map2.put(a, l);
            } else
                map2.get(a).add(i);
        }
        for (int i : map2.keySet()) {
            List<Integer> l = map2.get(i);
            if (!l.isEmpty()) {
                StringBuffer s = new StringBuffer();
                for (int j : l) {
                    s.append(j + " ");
                }
                System.out.println(s);
            }
        }
    }

    public static void dfs(Map<Integer, List<Integer>> map, int[] visted, int k, int o) {
        visted[k] = o;
        if (map.keySet().contains(k)) {
            for (int i : map.get(k)) {
                if (visted[i] == 0) {
                    dfs(map, visted, i, o);
                }
            }
        }
    }
}
