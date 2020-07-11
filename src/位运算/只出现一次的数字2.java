package 位运算;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class 只出现一次的数字2 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        int[] arr2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singlnNumber(arr));
        System.out.println(singlnNumber(arr2));
    }

    public static int singlnNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Integer i : nums) {
//            Integer count = map.get(i);
//            count = count == null ? 1 : ++count;
//            map.put(i, count);
//        }
//        for (Integer i : map.keySet()) {
//            if (map.get(i) == 1) {
//                return i;
//            }
//        }
//        return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;            // 这句不会执行
    }

    // 数学推导    有问题
//    public static int singlnNumber2(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//            sum += nums[i];
//        }
//        int sumMul = 0;
//        for (int n : set) {
//            sumMul += n;
//        }
//        sumMul = sumMul * 3;
//        return (sumMul - sum) / 2;
//    }
}
