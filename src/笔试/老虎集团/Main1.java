package 笔试.老虎集团;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个表达式字符串，里面包含正整数，“+”，“-”，请添加括号“(”，“)”，使得表达式的结果最大，并返回最大值。
 * 例如 ： "1-2-3+4"   添加括号为   "1-(2-3)+4"   得到最大结果6.
 * <p>
 * 表达式为非空，正确表达式，无需判断，括号添加数目不限。
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(getMaxResult("1-2-3+4"));
    }

    public static int getMaxResult(String expression) {
        List<Integer> res = help(expression);
        int result = 0;
        for (int num : res) {
            if (num >= result) {
                result = num;
            }
        }
        return result;
    }

    public static List<Integer> help(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-') {
                List<Integer> left = help(input.substring(0, i));
                List<Integer> right = help(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') {
                            res.add(l + r);
                        } else {
                            res.add(l - r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }

//    public static List<Integer> help(String input) {
//        List<Integer> result = new ArrayList<>();
//        int num = 0;
//        int index = 0;
//        while (index < input.length() && !isOperation(input.charAt(index))) {
//            num = num * 10 + input.charAt(index) - '0';
//            index++;
//        }
//        if (index == input.length()) {
//            result.add(num);
//            return result;
//        }
//        for (int i = 0; i < input.length(); i++) {
//            if (isOperation(input.charAt(i))) {
//                List<Integer> result1 = help(input.substring(0, i));
//                List<Integer> result2 = help(input.substring(i + 1));
//                for (int j = 0; j < result1.size(); j++) {
//                    for (int k = 0; k < result2.size(); k++) {
//                        char op = input.charAt(i);
//                        result.add(caculate(result1.get(j), op, result2.get(k)));
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    public static int caculate(int num1, char op, int num2) {
//        switch (op) {
//            case '+':
//                return num1 + num2;
//            case '-':
//                return num1 - num2;
//        }
//        return -1;
//    }
//
//    public static boolean isOperation(char ch) {
//        return ch == '+' || ch == '-';
//    }
}
