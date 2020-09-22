package 笔试.神州信息;

/**
 * 给定整数数组，使其各个数字整体向后移 N 个位置，如果后移的位置超过整数数组的长度，则将该数字从头开始继续后移。
 * <p>
 * 输入：
 * [1,2,3,4,5,6,7,8,9],2
 * 输出：
 * [8,9,1,2,3,4,5,6,7]
 */
public class Main1 {
    public static void main(String[] args) {

    }

    public static int[] pushIntArray(int[] arr, int pushOffset) {
        // write code here
        int n = arr.length;
        pushOffset = pushOffset % n;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            // System.out.println((i + pushOffset) % n);
            newArr[(i + pushOffset) % n] = arr[i];
            // System.out.println(newArr[(i + pushOffset) % n]);
        }
        return newArr;
    }
}