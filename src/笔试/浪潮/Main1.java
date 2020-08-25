package 笔试.浪潮;

import java.util.*;

/**
 * 某条街道两侧分别种植了一排树木，并按如下编号：
 * 1 3 5 7 ... 45 47 49 ... 99
 * 2 4 6 8 ... 46 48 50 ... 100
 * 但是有一些树木被砍去，希望你能找出一边最长的连续的大树。
 * <p>
 * 输入：
 * 第一行一个整数 N
 * 第二行 N 个整数表示被砍去树的编号
 * <p>
 * 输出：
 * M 和 X(表示从第 M 棵大树开始共有连续的 X 棵大树，如果有多个解，输出 M 最小的解即可)
 * <p>
 * 输入：
 * 5
 * 9 15 27 35 6
 * 输出：
 * 8 47
 */
public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] oddArr = new int[50];        // 奇数编号大树
//        oddArr[0] = 1;
//        for (int i = 2; i <= 50; i++) {
//            oddArr[i - 1] = 2 * i - 1;
//        }
//
//        int[] evenArr = new int[50];      // 偶数编号大树
//        for (int j = 1; j <= 50; j++) {
//            evenArr[j - 1] = j * 2;
//        }
//        while (sc.hasNext()) {
//            String input1 = sc.nextLine();
//            int N = Integer.parseInt(input1);
//            String input2 = sc.nextLine();
//            String[] cutTrees = input2.split(" ");
//
//            List<Integer> oddList = new ArrayList<>();
//            List<Integer> evenList = new ArrayList<>();
//            for (int j = 0; j < cutTrees.length; j++) {
//                int temp = Integer.parseInt(cutTrees[j]);
//                if ((temp & 1) == 0) {
//                    evenList.add(temp);   // 维护两个集合，砍去的大树编号为偶数
//                } else {
//                    oddList.add(temp);    // 砍去的大树编号为奇数
//                }
//            }
//
//            int[] oddLongest = getLongestTreeSequence(oddArr, oddList);
//            int[] evenLongedt = getLongestTreeSequence(evenArr, evenList);
//
//            if (oddLongest[1] > evenLongedt[1]) {
//                System.out.print(oddLongest[0] + " " + oddLongest[1]);
//            } else if (oddLongest[1] < evenLongedt[1]) {
//                System.out.print(evenLongedt[0] + " " + evenLongedt[1]);
//            } else {
//                if (evenLongedt[0] < oddLongest[0]) {
//                    System.out.print(evenLongedt[0] + " " + evenLongedt[1]);
//                } else {
//                    System.out.print(oddLongest[0] + " " + oddLongest[1]);
//                }
//            }
//        }


        // 另一种写法
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] A_1 = new int[51];
        int[] A_2 = new int[51];
        A_1[50] = 1;
        A_2[50] = 1;
        for (int i = 0; i < n; i++) {
            int cut = sc.nextInt();
            if (cut % 2 == 0) {
                A_2[cut / 2 - 1] = 1;
            } else {
                A_1[cut / 2] = 1;
            }
        }
        System.out.println(Arrays.toString(A_1));
        System.out.println(Arrays.toString(A_2));
        int curA = 0;
        int maxA = 0;
        int indexA = 0;
        for (int i = 0; i < 51; i++) {
            if (A_1[i] == 0) {
                curA += 1;
            } else {
                if (curA > maxA) {
                    maxA = curA;
                    indexA = (i - maxA) * 2 + 1;
                }
                curA = 0;
            }
        }

        int curB = 0;
        int maxB = 0;
        int indexB = 0;
        for (int i = 0; i < 51; i++) {
            if (A_2[i] == 0) {
                curB += 1;
            } else {
                if (curB > maxB) {
                    maxB = curB;
                    indexB = (i - maxB + 1) * 2;
                }
                curB = 0;
            }
        }
        String res = maxA > maxB ? indexA + " " + maxA : indexB + " " + maxB;
        System.out.println(res);
    }


    // 获取最长的连续大树编号
    public static int[] getLongestTreeSequence(int[] arr, List<Integer> cutTreeList) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        Collections.sort(cutTreeList);

        int pos = -1;
        int longest = 0;
        int i = 0;
        while (!queue.isEmpty() && i < cutTreeList.size()) {
            int cutTreeVal = cutTreeList.get(i);
            int curLen = 0;
            int curPos = queue.peek();
            while (!queue.isEmpty() && queue.peek() < cutTreeVal) {
                queue.poll();
                curLen++;
            }
            if (!queue.isEmpty() && cutTreeVal == queue.peek()) {
                queue.poll();
            }
            if (curLen > longest) {
                pos = curPos;
                longest = curLen;
            }
            i++;
        }
        if (!queue.isEmpty()) {
            if (queue.size() > longest) {
                pos = queue.peek();
                longest = queue.size();
            }
        }

        int[] ret = new int[2];
        ret[0] = pos;        // 位置
        ret[1] = longest;    // 长度
        return ret;
    }
}