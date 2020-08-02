package 七轮;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class 只出现一次的数字3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    // 自己写的
    public static int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        int index = 0;
        for (int n : set) {
            if (map.get(n) == 1) {
                nums[index++] = n;
            }
        }
        return Arrays.copyOf(nums, index);
    }

    // 方法 2
    public static int[] singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (int n : set) {
            result[i] = n;
            i++;
        }
        return result;
    }


    // 方法 3
    // 现在数组中有两个数字只出现 1 次，直接异或一次只能得到这两个数字的异或结果，但光从这个结果肯定无法得到这个两个数字。

    // 第一步：所有数异或，所有数异或之后的值就是两个只出现一次的数a,b异或后的值s。
    // 第二步：那我们用s & (-s) 可以得出s最低位(也就是最右边)为1的bit位(这个操作不太会事先知道)对应的数k，
    //  这里有一个很关键点就是：这个为1的bit位肯定只来之a.b其中的一个数字中的对应二进制位的1，这里有点卡主理解，比如我们把数字转成二进制运算看下：
    //  a：1 -> 0001
    //  b：2 -> 0010  => 0011. 不全为1的bit为进行异或操作就为1，这是异或的基本流程，然后我们操作s & (-s)之后得到的是0001，可以看到这个1是来之数字a的
    // 第三步：我们得到s&(-s)之后在对所有数进行&操作的话，就意味着可以将a和b区分在0和1的两个组，至于其他的数字如果相同的数字自然会分到一个组，可以用纸笔写下整个过程
    // 第四步：经过第三步之后就变成了只有一个数字存在一个其他都存在两个的数组(也就变成题目：136. 只出现一次的数字)，
    //  然后我们分别对两个组的所有数字再进行异或之后不就得到了要求的那两个数了嘛。
    public static int[] singleNumber3(int[] nums) {
        int s = 0;
        for (int num : nums) {   // 第一步
            s ^= num;
        }

        int k = s & (-s);        // 第二步

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & k) == 0) { // 第三第四步
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}