package 笔试.奇安信;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 输入："hello undo redo world."
 * 输出："hello world."
 */
// 80%     undo 后输入了新的单词就不可以继续 redo 了
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            System.out.println(solution(sc.nextLine()));
//        }
//    }
//
//    public static String solution(String s) {
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//        String[] split = s.split(" +");
//        Stack<String> stack = new Stack<>();
//        String peek_str = null;
//        for (int i = 0; i < split.length; i++) {
//            if (split[i].equals("undo")) {
//                if (!stack.isEmpty()) {
//                    peek_str = stack.pop();
//                }
//            } else if (split[i].equals("redo")) {
//                if (peek_str != null) {
//                    stack.push(peek_str);
//                }
//            } else {
//                stack.push(split[i]);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < stack.size(); i++) {
//            sb.append(stack.get(i)).append(" ");
//        }
//        return sb.toString().trim();
//    }
//}


import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() == 0) {
            System.out.println("");
            return;
        }
        String[] sArr = s.split("[ \t]");
        int sLen = sArr.length;
        // 使用 LinkedList 实现栈
        LinkedList<String> oriStack = new LinkedList<>();
        Stack<String> unStack = new Stack<>();
        for (int i = 0; i < sLen; i++) {
            if (sArr[i].compareTo("undo") == 0) {
                if (!oriStack.isEmpty()) {
                    unStack.push(oriStack.pollLast());
                }
            } else if (sArr[i].compareTo("redo") == 0) {
                if (!unStack.empty()) {
                    oriStack.addLast(unStack.pop());
                }
            } else {
                oriStack.addLast(sArr[i]);
                unStack.clear();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!oriStack.isEmpty()) {
            res.append(oriStack.pollFirst());
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        System.out.println(res.toString());
        return;
    }
}