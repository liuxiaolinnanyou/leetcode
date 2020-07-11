package sort_排序算法;

/*
    插入排序：是一种简单直观的排序方法，其基本思想在于每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子序列中，直到
             全部记录插入完成。（直接插入排序、折半插入排序、希尔排序）
 */
public class 直接插入排序 {
    public static void main(String[] args) {
        int arr[] = {4, 7, 2, 3, 6, 1, 5};
        System.out.println("排序前：");
        printArray(arr);
        System.out.println("排序后：");
        insertionSort(arr);
        printArray(arr);
    }

    // 插入排序
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
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
