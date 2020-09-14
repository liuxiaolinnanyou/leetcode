package 笔试.vivo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String node[] = input.substring(1, input.length() - 1).split(",");
        ArrayList<Integer>[] graph = new ArrayList[node.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[node.length];
        for (int i = 0; i < node.length; i++) {
            if (Integer.parseInt(node[i]) != -1) {
                graph[Integer.parseInt(node[i])].add(i);
                degree[i]++;
            }
        }
        boolean[] visit = new boolean[node.length];
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                visit[i] = true;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.remove(0);
            result.add(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                degree[graph[curr].get(i)]--;
            }
            graph[curr].clear();
            for (int i = 0; i < degree.length; i++) {
                if (!visit[i] && degree[i] == 0) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.print("\"");
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + ",");
        }
        System.out.println(result.get(result.size() - 1) + "\"");
    }
}