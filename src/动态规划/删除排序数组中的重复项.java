package 动态规划;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr1));
        System.out.println(removeDuplicates(arr2));
    }

    // 双指针法
    // 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，
    // 而 j 是快指针。只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项。
    // 当我们遇到 nums[j]!=nums[i] 时，跳过重复项的运行已经结束，
    // 因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。
    // 然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 优化
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    // 借助集合      这个不行    不符合题意
    public static int removeDuplicates3(int[] nums) {
        // 去重
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return set.size();
    }
}
