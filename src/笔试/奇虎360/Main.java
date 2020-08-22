package 笔试.奇虎360;

import java.util.Scanner;

/**
 * 合法名字
 * 如果名字仅有大小写英文字母组成且长度不超过10，则我们认为这个名字是真实有效的，否则就判定为恶意填写问卷。
 * 请你判断出有多少有效问卷(只要名字是真实有效的，就认为问卷有效)
 * <p>
 * 输入第一行包含一个正整数 n，表示收到的问卷数量(1 <= n <= 2000)
 * 接下来有 n 行，每行有一个由大小写英文字母，数字，下划线组成的字符串，分别表示一份问卷的名字，字符串长度不超过100
 * <p>
 * 输出只有一个整数，表示有效问卷的数量。
 * <p>
 * 5
 * BA
 * aOWVXARgUbJDG
 * OPPCSKNS
 * HFDJEEDA
 * ABBABBBBAABBBAABAAA
 * <p>
 * 2
 * E_DB2C
 * DC
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        for (String s : arr) {
            if (s.length() > 10 || s == null || s.length() == 0) {
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.contains("_")) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
