package 笔试.京东;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 姚凌峰写的
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.split(" ");
        int start = Integer.valueOf(strs[0]);
        int end = Integer.valueOf(strs[1]);
        int count = getParCount(start, end);
        System.out.println(count);
    }

    private static int getParCount(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isParAndSu(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isParAndSu(int num) {
        // System.out.println(num);
        String str = String.valueOf(num);
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chs);
        int i = 0, j = chs.length - 1;
        while (i <= j) {
            if (chs[i] != chs[j]) {
                if (chs[i + 1] != chs[j] && chs[i] != chs[j - 1]) {
                    return false;
                }
                if (chs[i + 1] == chs[j]) {   // 去掉此时的i
                    sb.deleteCharAt(i);
                    // System.out.println(sb.toString());
                    return isPar(sb.toString()) && f(Integer.valueOf(sb.toString()));
                } else { //去掉j
                    sb.deleteCharAt(j);
                    // System.out.println(sb.toString());
                    return isPar(sb.toString()) && f(Integer.valueOf(sb.toString()));
                }
            } else {
                i++;
                j--;
            }
        }
        i = 0;
        j = chs.length - 1;
        return f(num) || f(Integer.valueOf(sb.deleteCharAt((i + j) / 2).toString()));           // 是否是素数
    }

    private static boolean isPar(String strs) {
        int i = 0;
        int j = strs.length() - 1;
        while (i < j) {
            if (strs.charAt(i++) != strs.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(int a) {
        boolean ean = true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                ean = false;
                break;
            }
        }
        return ean;
    }
}
