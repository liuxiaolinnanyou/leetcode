package sort_排序算法;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 */
public class 根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {10000, 10000};
        int[] arr3 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] arr4 = {10, 100, 1000, 10000};
        System.out.println(Arrays.toString(sortByBits(arr)));
        System.out.println(Arrays.toString(sortByBits(arr2)));
        System.out.println(Arrays.toString(sortByBits(arr3)));
        System.out.println(Arrays.toString(sortByBits(arr4)));
//        System.out.println(Integer.bitCount(5));
//        System.out.println(Integer.bitCount(7));      // 统计二进制中 1 的个数

    }


    public static int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;       // 获取原来的数据
        }
        return map;
    }
}
