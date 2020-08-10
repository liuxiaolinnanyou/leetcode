package 笔试.阿里;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int[] fathers = new int[n + 1];
            fathers[0] = -1;
            fathers[1] = -1;
            for (int i = 1; i < n; i++) {
                int fathVal = scanner.nextInt();
                fathers[i + 1] = fathVal;
            }
            for (int i = 0; i < t; i++) {
                boolean[] used = new boolean[n + 1];
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                used[a] = true;
                used[b] = true;
                boolean flag = false;
                while (fathers[a] != -1 && fathers[b] != -1) {
                    a = fathers[a];
                    if (used[a]) {
                        System.out.println("B");
                        flag = true;
                        break;
                    }
                    used[a] = true;
                    b = fathers[b];
                    if (used[b]) {
                        System.out.println("A");
                        flag = true;
                        break;
                    }
                    used[b] = true;
                }
                if (!flag) {
                    if (fathers[a] == -1) {
                        System.out.println("A");
                    } else {
                        System.out.println("B");
                    }
                }
            }
        }
    }
}
