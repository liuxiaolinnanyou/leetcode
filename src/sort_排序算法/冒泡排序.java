package sort_排序算法;


public class 冒泡排序 {
    public static void main(String[] args) {
//        // 基本数据类型的数组转换成集合,会将整个数组当作一个对象转换，将数组转换成集合,数组必须是引用数据类型。
//
//        // Arrays.asList()方法转换成的List集合类是java.util.Arrays.ArrayList下面的，
//        // 它是java.util.Arrays类中自己定义的一个内部类，没有实现具体的add()以及remove()方法，
//        // 直接使用父类AbstractList的方法，但是父类中add()以及remove()方法是抛出UnsupportedOperationException()异常的。
//        int[] array = {5, 12, 45, 45, 16, 17, 17, 13};
////         List<Integer> list = Arrays.asList(array);     // 转换不了
//        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(array));
////        List<int[]> ints = Arrays.asList(array);
//        System.out.println(arrayList);
//        for (int[] arr : arrayList) {
//            for (int i : arr) {
//                System.out.println(i);
//            }
//        }
//
//        System.out.println("------------------分割线---------------------");
//        Integer[] arr = {1, 2, 3};
//        List<Integer> list = Arrays.asList(arr);
////        list.add(12);    // java.lang.UnsupportedOperationException     集合的长度不能改变
//        System.out.println(list.size());
//        System.out.println(list);


//        String [] arr = {"asd","asd","asdf"};
//        List<String> list = Arrays.asList(arr);
//        list.add("石原里美");     // UnsupportedOperationException
//        System.out.println(list.size());
//        System.out.println(list);


        int arr[] = {4, 7, 2, 3, 6, 1, 5};
        System.out.println("排序前：");
        printArray(arr);
        System.out.println("排序后：");
        bubbleSort(arr);
        printArray(arr);
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
                    swap(arr, i, i + 1);
                }
            }
        }
    }


    // 交换两个数据
    public static void swap(int[] arr, int i, int i1) {
        arr[i] = arr[i] ^ arr[i1];
        arr[i1] = arr[i] ^ arr[i1];
        arr[i] = arr[i] ^ arr[i1];
    }


    // 打印数组
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