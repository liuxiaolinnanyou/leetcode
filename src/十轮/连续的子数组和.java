package 十轮;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * <p>
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * <p>
 * 说明：
 * 数组的长度不会超过 10,000 。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 */
public class 连续的子数组和 {
    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(arr, 6));
        System.out.println(checkSubarraySum(arr, 0));
        System.out.println("-------------------------");
        System.out.println(checkSubarraySum2(arr, 6));
        System.out.println(checkSubarraySum2(arr, 0));
        System.out.println("-------------------------");
        System.out.println(checkSubarraySum3(arr, 6));
        System.out.println(checkSubarraySum3(arr, 0));
    }

    // dp
    // 分别算出长度为2，3，……m的子数组的和，判断是否为k的倍数即可
    // 我们将nums的数据拷贝到dp中
    // 计算长度为2的子数组和时：dp[j] = dp[j] + nums[j+1]; 这里的dp[j]就是nums[j]
    // 计算长度为3的子数组和时：dp[j] = dp[j] + nums[j+2]; 这里的dp[j]是更新过的dp[j]，一个dp[j]相当于nums[j]+nums[j+1]
    // 这样当计算长度为p的子数组大小时，就可以利用已经计算过的长度为p-1的子数组进行更新，
    // 就可以对原来的三重循环进行优化，变为二重循环
    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = new int[10010];
        if (nums.length < 2) {
            return false;
        }
        // k == 0 时单独考虑，其实和k!=0时只有做不做模运算的区别
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length - i; j++) {
                    dp[j] = dp[j] + nums[j + i];
                    if (i != 0 && dp[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        // 当i=k时，dp[j]表示以j为起始下标，nums中连续k+1个整数的和
        // 如当i=0时，相当于将nums拷贝到dp
        // i=1时，dp[0]相当于以0为起始下标，nums中2个整数的和，即nums[0]+nums[1]
        // 每次计算时都可以用原来的dp进行更新，而不用一个个去加
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                dp[j] = (dp[j] + nums[j + i]) % k;
                if (i != 0 && dp[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    // 前缀和
    public static boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {     // 遍历 nums
            sum += nums[i];
            preSum[i + 1] = sum;     // 保存的是累加和   [0, 23, 25, 29, 35, 42]
        }
//        System.out.println(Arrays.toString(preSum));
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 2; j < preSum.length; j++) {
                int temp = preSum[j] - preSum[i];
                if ((temp == 0 && k == 0) || (k != 0 && temp % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 使用 hashMap 的单次遍历
    public static boolean checkSubarraySum3(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 键为 preSum % k, 值为索引，当然要特殊处理k == 0的情况
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = k == 0 ? sum : sum % k;
            if (map.containsKey(temp)) {        // 出现相同的键，如果子数组长度少于2， 不需要更新值。
                if (i - map.get(temp) > 1) {    // 子数组要求长度至少为2。
                    return true;
                }
                continue;
            }
            map.put(temp, i);
        }
        return false;
    }

    // 每当我们计算出一个前缀和 sum[j] 时，我们判断哈希表中是否存在键值为 sum[j]%k，
    // 若存在则有 sum[j]%k=sum[i]%k，我们返回 True。
    // 由于我们需要控制子数组长度大于等 2，因此每次计算出的 sum[j]%k 的值，我们不能立即放入字典中，
    // 而是引入一个中间变量 cache 缓存我们的值，待下一次计算时再加入字典，以保证满足条件的子数组长度至少为 2。
    // 对 k=0 的情形，我们需要特判。
    public static boolean checkSubarraySum4(int[] nums, int k) {
        int N = nums.length, cache = 0;
        int[] sum = new int[N + 1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int res = k == 0 ? sum[i + 1] : sum[i + 1] % k;
            if (set.contains(res)) {
                return true;
            }
            set.add(cache);
            cache = res;
        }
        return false;
    }
}