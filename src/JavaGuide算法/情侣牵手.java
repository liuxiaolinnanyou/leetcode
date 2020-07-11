package JavaGuide算法;

/**
 * @author Lxl
 * @version 1.0
 * @date 2020/6/10 10:40
 */

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
 * 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，
 * 情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 */
public class 情侣牵手 {
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        int[] row2 = {3, 2, 0, 1};
        System.out.println(minSwapsCouples(row));
        System.out.println(minSwapsCouples(row2));
    }

    // 根据我们的假设，可以制定按顺序让每张沙发上情侣开心的策略。
    // 对于每张沙发，找到沙发上第一个人的情侣，
    // 如果不在同一个沙发上，就把沙发上的第二人换成第一个人的情侣。
    // 如果一个人的编号为 x，那么他的情侣的编号为 x ^ 1， ^ 在这里是异或操作。
    // 对于每张沙发上的第一个人 x = row[i]，找到他们的同伴所在的位置 row[j]，将 row[j] 和 row[i + 1] 互相交换。
    // 偶数^1 = 偶数+1
    // 奇数^1 = 奇数-1
    public static int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];    // 依次遍历偶数位置的数字
            if (row[i + 1] == (x ^ 1)) {
                continue;      // 是情侣就不操作
            }
            ans++;             // 不是情侣就需要进行交换 ans++
            for (int j = i + 1; j < row.length; ++j) {
                if (row[j] == (x ^ 1)) {   // 依次向后遍历，找出位置 i 对应的伴侣
                    row[j] = row[i + 1];
                    row[i + 1] = x ^ 1;
                    break;                 // 找到进行交换，交换完成就退出
                }
            }
        }
        return ans;
    }
}
