package 六轮;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class 颜色分类 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(arr));
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 自己写的    类似桶排序
    public static void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int num : nums) {
            arr[num]++;
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                nums[index++] = i;
                arr[i]--;
            }
        }
        return;
    }

    // 双指针
    public static void sortColors2(int[] nums) {
        int N = nums.length;
        int[] res = Arrays.copyOf(nums, N);          // 把 nums 复制到 res
        int start = 0;
        int end = N - 1;
        for (int i = 0; i < N; i++) {
            if (res[i] == 0) {              // 遍历到 0 放到前面去， start 向后
                nums[start++] = 0;
            } else if (res[i] == 2) {       // 遍历到 2 放到最后面去，end 向前
                nums[end--] = 2;
            }
        }
        for (int i = start; i <= end; i++) {
            nums[i] = 1;        // 中间的都是 1
        }
    }
}