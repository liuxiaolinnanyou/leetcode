package sort_排序算法;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class 数组的相对排序 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    // 桶排序  不需要额外的空间
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 由于arr1的可能取值为0-1000，共1001个取值，不算一个很大的取值范围，所以可以利用桶式排序
        int[] bucket = new int[1001];
        // 计数每个桶有多少个数，也就是每个值在数组中有几个
        for (int num : arr1) {
            bucket[num]++;
        }
        // 由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
        int i = 0;
        // 由于排序是按照相对顺序进行排序，所以，首先根据arr2中的桶的顺序，依次从对应的桶中取数到arr1中
        // 并注意，每拿出一个数，需要将对桶中的数的个数进行-1操作
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                arr1[i++] = num;
            }
        }
        // 未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
        for (int j = 0; j < 1001; ++j) {
            while (bucket[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }


    // 方法 2   其实就是桶排序
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] m = new int[1001];

        int[] ref = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }

        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }
}
