package 笔试.爱奇艺;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(isValid(sc.nextLine()));
        }
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char theChar = s.charAt(i);
            if (theChar == '(' || theChar == '{' || theChar == '[') {
                stack.push(theChar);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char preChar = stack.peek();
                if ((preChar == '{' && theChar == '}') || (preChar == '(' && theChar == ')') || (preChar == '[' && theChar == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}