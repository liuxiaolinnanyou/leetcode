package 笔试.阿里;

import java.util.Scanner;

/**
 * 小强和小明在玩一个游戏，这个游戏是这样的，给你一棵树，两个人初始在这棵树上的某一个节点（两个人不重合），
 * 两个人轮流在树上移动，每一次移动一个位置，可以移动到父亲节点，也可以移动到孩子节点，若移动后一个人是另一个人
 * 的祖先节点，则在祖先节点的这个人获胜，假设两个人足够聪明，问谁能获胜，为了输出方便，我们假设，小强获胜输出“A”
 * 小明获胜输出“B”，且小强优先去移动，即小强是先手方。
 * <p>
 * 输入描述：
 * 对于每一组测试数据，一行输入两个整数n和m，代表树的节点数量以及游戏的轮数。
 * 接下来n-1个数，代表i+1的父亲节点是fa[i]。
 * 接下来m行数，每一行两个数x和y代表牛牛和牛妹初始在的位置。
 * 编号为1的节点永远是根节点
 * 1 <= n,m <= 10^5
 * 1 <= fa[i] <= i
 * 1 <= x,y <= n
 * <p>
 * 输出描述：
 * 对于每一组测试数据，每一轮输出一个答案A代表小强获胜，答案B代表小明获胜
 * <p>
 * 输入：
 * 5 3
 * 1 1 2 4
 * 2 3
 * 2 1
 * 4 3
 * <p>
 * 输出：
 * A
 * B
 * B
 * <p>
 * 小强先手走到节点1
 * 小强在移动前就已经输了，所以输出B
 * 小强先手走到节点2，小明后手走到节点1，此时小明已经获胜。
 */
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
