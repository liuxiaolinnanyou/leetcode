package 达西;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * 输入: ["23:59","00:00"]
 * 输出: 1
 */
public class 最小时间差 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(findMinDifference(list));
    }

    // 把每一处的时间转化为分钟，排序后，依次比较与前一位的差，记得不要忘记比较最后一位与第一位
    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int i = 0;
        for (String timePoint : timePoints) {
            int time = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3, 5));
            times[i] = time;
            i++;
        }
        // 排序
        Arrays.sort(times);
        int result = 1440 - times[times.length - 1] + times[0];   // 比较最后一位与第一位
        for (int j = 1; j < times.length; j++) {
            if (times[j] - times[j - 1] < result) {
                result = times[j] - times[j - 1];
            }
        }
        return result;
    }
}