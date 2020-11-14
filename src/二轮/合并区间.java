package 二轮;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr2 = {{1, 4}, {4, 5}};
    }

    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] arr : intervals) {
            if (index == -1 || result[index][1] < arr[0]) {
                result[++index] = arr;
            } else {
                result[index][1] = Math.max(result[index][1], arr[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
