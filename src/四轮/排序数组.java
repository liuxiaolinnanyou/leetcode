package 四轮;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class 排序数组 {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 1};
        int[] arr2 = {5, 1, 1, 2, 0, 0};
        System.out.println(sortArray(arr1));
        System.out.println(sortArray(arr2));
    }

    // 菜鸡写法
    public static int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        int index = 0;
        for (int num : list) {
            res[index++] = num;
        }
        return res;
    }

    // 考察排序算法    插入排序
    public static int[] sortArray2(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
