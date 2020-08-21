package 十轮;

import java.util.HashSet;
import java.util.Set;

/**
 * 我们有一个非负整数数组 A。
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），
 * 我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * 返回可能结果的数量。（多次出现的结果在最终答案中仅计算一次。）
 * <p>
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 * <p>
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * <p>
 * 输入：[1,2,4]
 * 输出：6
 * 解释：
 * 可能的结果是 1，2，3，4，6，以及 7 。
 * <p>
 * 提示：
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 10^9
 */
public class 子数组按位或操作 {
    public static void main(String[] args) {

    }

    // 动态规划法
    // 基本思想官方题解里已经解释了，就是当累计的或结果满足32全是1的状态时就不再发生变化了。后面的结果就可以不用计算了
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((A[i] | A[j]) == A[j]) {
                    // 说明，A[j]已经为32位全是1的状态了，无需进行后续操作了
                    break;
                }
                // 这里的 A[j] 的值表示从A[j]|...|A[i]的结果，存贮下来下一轮使用 dp思想
                A[j] |= A[i];
                // 比如这里 i=4,那么A[j] j>=0&&j<=3 就表示A[0]|..|A[4] A[1]|..|A[4] A[2]|..|A[4] A[3]|A[4]
                set.add(A[j]);
            }
        }
        return set.size();
    }
}
