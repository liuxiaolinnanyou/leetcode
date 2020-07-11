package vivo_2020;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 * <p>
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * <p>
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 * <p>
 * 提示：
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 */
public class 判断路径是否相交 {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NESWW"));
    }

    // 方法 1    掌握
    public static boolean isPathCrossing(String path) {
        // 如果为 null 或者为空，认为没有走，直接返回 false
        if (path == null || "".equals(path)) {
            return false;
        }

        // 定义初始坐标
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        // 添加原点  将坐标点添加到set集合
        set.add("0,0");

        // 遍历字符串，记录坐标
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
                default:    // 加个默认(规范一点),防止出现不正当的字符
                    break;
            }
            // 如果添加失败(已经走过的坐标),则返回true;
            if (!set.add(x + "," + y)) {
                return true;
            }
        }
        // 没有出现重复坐标，返回false
        return false;
    }


    // 方法 2   使用hash表  取值范围在[-10000,10000]内，共有20001种可能
    public static boolean isPathCrossing2(String path) {
        Set<Integer> visit = new HashSet<>();
        int x = 0;
        int y = 0;
        visit.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N':
                    --x;
                    break;
                case 'S':
                    ++x;
                    break;
                case 'W':
                    --y;
                    break;
                case 'E':
                    ++y;
                    break;
                default:
                    break;
            }
            int hashValue = getHash(x, y);
            if (!visit.add(hashValue)) {     // 这里做了两个运算：添加和判断
                return true;
            }
        }
        return false;
    }

    private static int getHash(int x, int y) {
        return x * 20001 + y;
    }
}
