package newcoder_剑指offer;

// 删除一次得到子数组最大和
// 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
// 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），
// （删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
// 注意，删除一个元素后，子数组 不能为空。

// 输入：arr = [1,-2,0,3]
// 输出：4
// 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。

// 输入：arr = [1,-2,-2,3]
// 输出：3
// 解释：我们直接选出 [3]，这就是最大和。

// 输入：arr = [-1,-1,-1,-1]
// 输出：-1
// 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。

// 动态规划法
public class 子数组最大和 {
    public static void main(String[] args) {
        int[] arr = {1, -2, -2, 3};
        System.out.println(maximumSum(arr));
    }

    public static int maximumSum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] prefixDp = new int[arr.length];    // 正向DP prefixDp[i] 从 0 到 i 元素的最大子数组和
        int[] suffixDp = new int[arr.length];    // 逆向DP suffixDp[i] 从 arr.len 到 i 的最大子数组和
        prefixDp[0] = arr[0];
        suffixDp[arr.length - 1] = arr[arr.length - 1];
        int max = Integer.MIN_VALUE;             // -2147483648
        for (int i = 1; i < arr.length; i++) {
            prefixDp[i] = Math.max(prefixDp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, prefixDp[i]);
            suffixDp[arr.length - 1 - i] = Math.max(suffixDp[arr.length - i] + arr[arr.length - 1 - i],
                    arr[arr.length - 1 - i]);
            max = Math.max(max, prefixDp[i]);
        }

        for (int i = 0; i < arr.length; i++) {    // 删掉下标为i之后的最大值
            int left = i != 0 ? prefixDp[i - 1] : 0;
            int right = i != arr.length - 1 ? suffixDp[i + 1] : 0;
            max = Math.max(max, left + right);
        }
        return max;
    }
}
