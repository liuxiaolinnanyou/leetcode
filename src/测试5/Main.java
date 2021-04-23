package 测试5;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写函数 printChars(int total,int step)
 * total表示 * 的个数，step 表示每行 * 数量等差递增量， * 不足用 ？ 补齐，靠右对齐，用空格补位。
 */
public class Main {
    public static void main(String[] args) {
        printChars(18, 2);
    }

    public static void printChars(int total, int step) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        int sum = 0;
        while (sum < total) {
            sum += cur;
            list.add(cur);
            cur += step;
        }
        cur = cur - step;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < cur - list.get(i); j++) {
                System.out.print(' ');
            }
            for (int j = cur - list.get(i); j < cur; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        // 打印最后一行
        for (int i = 0; i < cur - (sum - total); i++) {
            System.out.print('*');
        }
        for (int i = cur - (sum - total); i < cur; i++) {
            System.out.print('?');
        }
    }
}