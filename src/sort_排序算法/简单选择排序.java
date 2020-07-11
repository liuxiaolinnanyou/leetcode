package sort_排序算法;

public class 简单选择排序 {
    public static void main(String[] args) {
        int arr[] = {4, 7, 2, 3, 6, 1, 5};
        System.out.println("排序前：");
        printArray(arr);
        System.out.println("排序后：");
        selectionSort(arr);
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    // 交换两个数据
    public static void swap(int[] arr, int i, int i1) {
        arr[i] = arr[i] ^ arr[i1];
        arr[i1] = arr[i] ^ arr[i1];
        arr[i] = arr[i] ^ arr[i1];
    }


    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
