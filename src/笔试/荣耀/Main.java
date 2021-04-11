package 笔试.荣耀;

/**
 * 输入：LIming0701
 * 输出：5464640701
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, String> map = new HashMap<String, String>() {{
        put("abc", "2");
        put("def", "3");
        put("ghi", "4");
        put("jkl", "5");
        put("mno", "6");
        put("pqrs", "7");
        put("tuv", "8");
        put("wxyz", "9");
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                if (Character.isLowerCase(s.charAt(i))) {
                    for (String ss : map.keySet()) {
                        if (ss.contains("" + s.charAt(i))) {
                            stringBuilder.append(map.get(ss));
                        }
                    }
                } else {
                    char c = Character.toLowerCase(s.charAt(i));
                    if (c == 'a') {
                        c = 'z';
                    } else {
                        c = (char) (c - 1);
                    }
                    for (String ss : map.keySet()) {
                        if (ss.contains("" + c)) {
                            stringBuilder.append(map.get(ss));
                        }
                    }
                }
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }
}