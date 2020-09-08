package newcoder_剑指offer;

// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
// NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class 数组的旋转 {
    public static void main(String[] args) {
//        int[] arr = new int[3];
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
    }

    // 笨方法
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 方法 2     利用题目条件
    public static int minNumberInRotateArray2(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] < array[j]) {
                return array[i];
            }
            int mid = (i + j) >> 1;
            if (array[mid] > array[i]) {
                i = mid + 1;
            } else if (array[mid] < array[j]) {
                j = mid;    // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
            } else {
                i++;      // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
            }
        }
        return array[i];
    }
}