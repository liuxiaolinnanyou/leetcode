package JavaGuide算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class 四数之和 {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(arr, 0);
        System.out.println(list);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int len = nums.length - 3;
        Arrays.sort(nums);     // 排序
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;      // 去重
            }
            for (int j = nums.length - 1; j > i + 1; j--) {    // j 从最后一个位置开始向前遍历
                int l = i + 1;
                int r = j - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r] + nums[j];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r], nums[j]);
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                        r--;
                    }
                    if (sum > target) {
                        r--;
                    }
                    if (sum < target) {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
