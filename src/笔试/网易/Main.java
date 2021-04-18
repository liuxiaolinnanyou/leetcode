package 笔试.网易;

// AC 100
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String ss = split[1];
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getKey();
            if (map.get(s) >= 2) {
                res++;
            }
        }
        System.out.println(res);
    }
}