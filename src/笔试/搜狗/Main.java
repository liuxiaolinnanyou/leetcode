package 笔试.搜狗;

/**
 * 三种道具 A , B , C，两种可以换成任意一种
 * <p>
 * 输入：4,4,2
 * 输出：3
 * <p>
 * 输入：9,3,3
 * 输出：4
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(numberofprize(4, 4, 2));
        System.out.println(numberofprize(9, 3, 3));
    }

    public static int numberofprize(int a, int b, int c) {
        int l = Math.min(a, Math.min(b, c));
        int r = Math.max(a, Math.max(b, c));
        while (true) {
            if (l + 1 >= r) {
                if (check(new int[]{a, b, c}, r)) {
                    return r;
                }
                return l;
            }
            int mid = (l + r) / 2;
            if (check(new int[]{a, b, c}, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
    }

    public static boolean check(int[] arr, int num) {
        int n1 = 0;
        int n2 = 0;
        for (int arrNum : arr) {
            if (arrNum >= num) {
                n1 += arrNum - num;
            } else {
                n2 += num - arrNum;
            }
        }
        return n1 / 2 >= n2;
    }
}