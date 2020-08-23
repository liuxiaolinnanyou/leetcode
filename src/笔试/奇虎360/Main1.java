package 笔试.奇虎360;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main1 {       // 会超时
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] nums = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = i + 1;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            list.add(sc.nextInt());
//        }
//        for (int k : list) {
//            if (k == 1) {
//                int s = nums[0];
//                for (int i = 1; i < nums.length; i++) {
//                    nums[i - 1] = nums[i];
//                }
//                nums[nums.length - 1] = s;
//            }
//            if (k == 2) {
//                for (int i = 1; i < nums.length; i += 2) {
//                    int temp = nums[i - 1];
//                    nums[i - 1] = nums[i];
//                    nums[i] = temp;
//                }
//            }
//        }
//        StringBuffer sb = new StringBuffer();
//        for (int a : nums) {
//            sb.append(a + " ");
//        }
//        System.out.println(sb);
//    }
//}


/**
 * 给定一个 1 到 n 的排列 P1 到 Pn， n为整数，初始时 Pi=i (1 <= i <= n)，现在要对排列进行 m 次操作，每次操作为以下两种中的一种：
 * 1.将排列的第1个数移到末尾
 * 2.交换排列的第1个数和第二个数，第三个数和第四个数，。。。 第n-1个数和第n个数。
 * 求经过这m次操作后得到的排列
 * <p>
 * 第一行包含两个整数 n 和 m ，n >= 2, m <= 10^5
 * 第二行包含 m 个空格隔开的整数 t1 到 tm ，1 <= ti <= 2  1 表示第 i 次操作为操作 1   2 表示第 i 次操作为 2
 * <p>
 * 输出 n 个空格隔开的整数，即经过 m 次操作后得到的排列。
 * <p>
 * 输入：
 * 4 3
 * 1 2 1
 * 输出：
 * 2 1 4 3
 * <p>
 * 说明：{1,2,3,4} {2,3,4,1} {3,2,1,4} {2,1,4,3}
 */

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        LinkedList<Integer> his1 = new LinkedList<>();
        LinkedList<Integer> his2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                his1.addLast(i + 1);
            } else {
                his2.addLast(i + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if (tmp == 1) {
                int t = his1.pollFirst();
                his1.addLast(t);
            }
            LinkedList<Integer> tmpHis = his1;
            his1 = his2;
            his2 = tmpHis;
        }

        while (!his2.isEmpty()) {
            System.out.printf("%d ", his1.pollFirst());
            System.out.printf("%d ", his2.pollFirst());
        }
        System.out.println();
    }
}