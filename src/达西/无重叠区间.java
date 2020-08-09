package 达西;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意：
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] arr2 = {{1, 2}, {1, 2}, {1, 2}};
        int[][] arr3 = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(arr1));
        System.out.println(eraseOverlapIntervals(arr2));
        System.out.println(eraseOverlapIntervals(arr3));
    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int result = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[pre][1] <= intervals[i][0]) {    // 统计不需要删除的个数
                pre = i;
                result++;
            }
        }
        return intervals.length - result;
    }
}
