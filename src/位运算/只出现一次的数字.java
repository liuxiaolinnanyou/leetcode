package 位运算;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1};
        int[] arr2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber(arr2));
        System.out.println("------------------分隔符------------------");
        System.out.println(singleNumber2(arr));
        System.out.println(singleNumber2(arr2));
    }

    // 方法 1     借助 map 集合
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    // 方法 2      异或
    public static int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
