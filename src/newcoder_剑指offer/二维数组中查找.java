package newcoder_剑指offer;

// 二维数组中的查找
// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class 二维数组中查找 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(arr, 15));
        System.out.println(find2(arr, 15));
    }

    // 方法 1  暴力法
    public static boolean find(int[][] arr, int target) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (target == arr[x][y]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 方法 2
    public static boolean find2(int[][] arr, int target) {
        int rows = arr.length;
        if (rows == 0) {
            return false;
        }

        int cols = arr[0].length;
        if (cols == 0) {
            return false;
        }

        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (arr[row][col] < target) {
                col++;
            } else if (arr[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
