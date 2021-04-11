package 笔试.B站;

import java.util.ArrayList;

/**
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * <p>
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * <p>
 * 注意:
 * <p>
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，
 * 表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
public class 二十四点游戏 {
    /**
     * 代码完全借鉴的官方题解，主要对题解中不明白的部分进行说明。
     * <p>
     * 处理逻辑是从4张牌里面进行选择，每次由2张牌合为一张牌，进行下一轮处理，所以总共有3轮。
     * 第一轮：从4张牌里面任意选两个进行4种操作，
     * 第二轮：从3张牌里面任意选两个进行4种操作，
     * 第三轮：从2张牌选两个进行4种操作
     * <p>
     * 可能的选择和操作总数是，(12 * 4) * (6 * 4) * (2 * 4) = 9216种
     * 12 * 4 就是4张牌里面任意选前2个数的组合，这两个数字进行4种操作
     * 6 * 4 就是3张牌里面任意选前2个数的组合，这两个数字进行4种操作
     * 2 * 4 就是2张牌里面任意选前2个数的组合，已经4种操作后的结果。
     * 以上都考虑全排列的结果，每次选择都考虑顺序的不同在除法和减法时候的不同，乘法和加法不影响。
     * <p>
     * 举例说明：假设为1 2 3 4 四个数字
     * 4张牌全排列是4的阶乘，4！= 24，由于要每次取两个数字，
     * 两个一样的数字如下会有重复的排列需要去重，
     * 后面的数字部分是下一轮要考虑的，第一轮不考虑；
     * 1 2 3 4, 1 2 4 3, 1 3 2 4, 1 3 4 3, 1 4 2 3, 1 4 3 2,
     * 2 1 3 4, 2 1 4 3, 2 3 1 4, 2 3 4 1, 2 4 1 3, 2 4 3 1,
     * 3 1 2 4, 3 1 4 2, 3 2 1 4, 3 2 4 1, 3 4 1 2, 3 4 2 1,
     * 4 1 2 3, 4 1 3 2, 4 2 1 3, 4 2 3 1, 4 3 1 2, 4 3 2 1
     * <p>
     * 第二轮循环假设为 2 3 4 三个数字，可以看到有6中情况
     * 2 3 4, 2 4 3, 3 2 4, 3 4 2, 4 2 3, 4 3 2
     * <p>
     * 第三轮循环假设为 4 6 两个数字，所以是两种情况，但是里面 + 和 * 的结果是一样的，当时 / 和 - 会不同
     * 4 6，6 4
     */
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 7};
        int[] arr2 = {1, 2, 1, 2};
        System.out.println(judgePoint24(arr1));
        System.out.println(judgePoint24(arr2));
    }

    public static boolean judgePoint24(int[] nums) {
        ArrayList<Double> A = new ArrayList<>();
        for (int v : nums) {
            A.add((double) v);
        }
        return solve(A);
    }

    private static boolean solve(ArrayList<Double> nums) {
        // 没有可计算的，证明无解
        if (nums.size() == 0) {
            return false;
        }
        // le-6是浮点计算的精度误差，这里判断误差小于1e-6，这样就是正确结果
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }


        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    // 找到当前排列下的其他两个元素
                    ArrayList<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    }

                    // k的四种计算情况
                    for (int k = 0; k < 4; k++) {
                        // 性能优化，当k<2时，对于+ or *不考虑顺序，
                        // 所以k<2 时，j > i与i > j的结果相同，所以有部分不用考虑
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                        }
                        if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                        }
                        if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                        }
                        // 避免除数为0
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        // 在这次计算后，判断剩下的元素是否符合要求
                        // 每次缩小计算范围
                        if (solve(nums2)) {
                            return true;
                        }
                        // 移除最后一个计算结果，因为最后的记过不满足要求
                        // 就是一种回溯方法，将前面添加的结果删除
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}