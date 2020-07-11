package 数组;

import java.util.ArrayList;

/**
 * 假设两个含有n个元素的有序(非降序)整型数组 a 和 b ，其中 a=[0,1,2,3,4], b=[1,3,5,7,9],交集为 [1,3]
 */
public class 两个有序整型数组的交集 {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {1, 3, 5, 7, 9};
        ArrayList<Integer> mixed = mixed(arr1, arr2);
        System.out.println(mixed);
    }

    public static ArrayList<Integer> mixed(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        while (i < len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            }
        }
        return list;
    }
}
