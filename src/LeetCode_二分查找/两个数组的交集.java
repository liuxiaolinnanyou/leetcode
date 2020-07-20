package LeetCode_二分查找;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定两个数组，编写一个函数来计算它们的交集。

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        int[] nums11 = {4, 9, 5};
        int[] nums22 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection2(nums11, nums22)));
    }

    // 方法1  借助集合
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num : nums1) {
            parentSet.add(num);
        }
        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        // 将 set 集合转换成数组
        int[] resArr = new int[childSet.size()];
        int index = 0;
        for (int value : childSet) {
            resArr[index++] = value;
        }
        return resArr;
    }


    // 方法2 双指针 先将 nums1 与 nums2 排序，然后游走两个指针，情况都写出来了
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        // 将 set 集合转换成数组
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }
}