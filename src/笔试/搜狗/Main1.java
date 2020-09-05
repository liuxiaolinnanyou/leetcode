package 笔试.搜狗;

// AC 10
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 5, 2};
        System.out.println(getHouses(2, arr));
    }

    public static int getHouses(int t, int[] xa) {
        if (xa == null || xa.length == 0 || xa.length % 2 != 0) {
            return 0;
        }
        int[] arr1 = new int[xa.length / 2];
        double[] arr2 = new double[xa.length / 2];
        int index = 0;
        for (int i = 0; i < xa.length; i += 2) {
            arr1[index] = xa[i];
            arr2[index] = (double) xa[i + 1] / 2;
            index++;
        }
        index = 0;
        double[] arr = new double[xa.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[index] = (double) arr1[i] - arr2[i];
            index++;
            arr[index] = (double) arr1[i] + arr2[i];
            index++;
        }
        int count = 2;
        for (int i = 1; i < arr.length - 1; i += 2) {
            if (arr[i + 1] - arr[i] > t) {
                count += (int) ((int) (arr[i + 1] - arr[i]) - t + 1);
            }
        }
        return count;
    }
}
