package 笔试.荣耀;

/**
 * 先按照水果分组，然后按工人的搬运重量从小到大进行排序，并将排序后的信息打印出来。如果工人的搬运重量相同，则按照
 * 编号的大小进行从小到大排序，并且要求水果输出的次序同输入次序。
 * <p>
 * 输入：
 * 5            工人的个数
 * Apple 1 80
 * Apple 2 62
 * Apple 4 73
 * Orange 4 65
 * Orange 1 90
 * Apple 3 91
 * Orange 3 88
 * Orange 5 90
 * 输出：
 * Apple 2 62
 * Apple 4 73
 * Apple 1 80
 * Apple 3 91
 * Orange 4 65
 * Orange 3 88
 * Orange 1 90
 * Orange 5 90
 */

// AC 0

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (set.size() != n) {
            String s = scanner.nextLine();
            list.add(s);
            set.add(Integer.parseInt(s.split(" ")[1]));
        }
        scanner.close();

        int len = list.size();
        String[][] arr = new String[len][3];
        int i = 0;
        for (String s : list) {
            String[] split = s.split(" ");
            arr[i][0] = split[0];
            arr[i][1] = split[1];
            arr[i][2] = split[2];
            i++;
        }

//        for (String[] str : arr) {
//            System.out.println(Arrays.toString(str));
//        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int num1 = o1[0].compareTo(o2[0]);
                int num2 = num1 == 0 ? Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]) : num1;
                int num3 = num2 == 0 ? Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]) : num2;
                return num3;
            }
        });

        for (String[] str : arr) {
            String ss = str[0] + " " + str[1] + " " + str[2];
            System.out.println(ss);
        }
    }
}