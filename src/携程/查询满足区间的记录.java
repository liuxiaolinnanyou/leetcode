package 携程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 有一批订单记录，数据有订单号，入店时间，离店时间；
 * 输入一个时间值A，需要在这批记录中找到符合入离店时间范围（A大于等于入店时间，
 * 并且A小于等于离店时间）内的所有记录。 单次查询时间复杂度控制在O(logN)
 * ※注意：订单号升序输出
 * <p>
 * 输入：
 * 记录数：10
 * 时间值A：20180602
 * 订单号 入店时间 离店时间
 * 1001 20180103 20180105
 * 1002 20180202 20180203
 * 1003 20180304 20180306
 * 1004 20180401 20180408
 * 1005 20180501 20180504
 * 1006 20180601 20180604
 * 1007 20180705 20180706
 * 1008 20180801 20180804
 * 1009 20180903 20180903
 * 1010 20181003 20181003
 * 以上输入都为整型
 * 输出：
 * 1006
 * <p>
 * 输入：
 * 5
 * 20170103
 * 1013 20180103 20180105
 * 1022 20180102 20180103
 * 1103 20180104 20180106
 * 1034 20180101 20180102
 * 1105 20180201 20180204
 * 输出：
 * null   查不到时输出null字符串（小写）
 * <p>
 * 输入：
 * 4
 * 20180103
 * 1013 20180103 20180105
 * 1022 20180102 20180103
 * 1026 20180103 20180103
 * 1007 20180101 20180109
 * 输出：
 * 1007
 * 1013
 * 1022
 * 1026
 */
public class 查询满足区间的记录 {
    public static void main(String[] args) {
        // 输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        int[][] data = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = sc.nextInt();
            }
            if (data[i][1] <= A && data[i][2] >= A) {
                list.add(data[i][0]);
            }
        }
        if (list.size() == 0) {
            System.out.println("null");   // 没有的话也是要输出结果的！以字符串的形式输出！
            return;
        }
        // 接下来给动态数组排序
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
