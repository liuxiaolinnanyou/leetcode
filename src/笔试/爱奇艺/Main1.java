package 笔试.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(isPathCrossing(sc.nextLine()));
        }
    }

    public static boolean isPathCrossing(String path) {
        if (path == null || "".equals(path)) {
            return false;
        }

        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();

        set.add("0,0");

        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            if (!set.add(x + "," + y)) {
                return true;
            }
        }
        return false;
    }
}
