package 达西;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入：[[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入：[[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class 合并区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        System.out.println(merge(array));
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(array[i]));
//        }
        sc.close();

//        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] arr2 = {{1, 4}, {4, 5}};
//        System.out.println(merge(arr1));
//        System.out.println(merge(arr2));
    }

    public static int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        // 遍历区间
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] arr : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (index == -1 || arr[0] > result[index][1]) {
                result[++index] = arr;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                result[index][1] = Math.max(result[index][1], arr[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
