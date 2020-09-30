package 笔试.小红书;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 不会
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        System.out.println(splitMsg(s).length);
        for (String s1 : splitMsg(s)) {
            System.out.println(s1);
        }
    }

    public static String[] splitMsg(String text) {
        String[] para = text.split("\n");
        System.out.println(para.length);
        List<String> res = new ArrayList<>();

        for (String s : para) {
//            String[] sList = s.split("[!;.,]");
            int pos = 0;
            StringBuilder tmp = new StringBuilder();
            int slen = s.length();
            if (slen <= 1024) {
                res.add(s);
                continue;
            }
            int lastDot = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.' || s.charAt(i) == ',' || s.charAt(i) == '!' || s.charAt(i) == ';') {
                    if (tmp.length() + i - lastDot + 1 > 1024) {
                        res.add(tmp.toString());
                        tmp = new StringBuilder();
                    }
                    tmp.append(s.substring(lastDot, i + 1));
                    lastDot = i + 2;
                }
            }
            if (tmp.length() > 0) {
                res.add(tmp.toString());
            }
        }
        int retLen = res.size();
        String[] ret = new String[retLen];
        for (int i = 0; i < retLen; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}