package 笔试.趋势科技;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 给出二叉树的中序和后序遍历结果。
 * 输入：输入为两个字符串(小写字符，以空格分隔)，每个字符串的一位字符代表一个节点。
 * 输出：给出先序遍历字符串结果
 * <p>
 * 输入：bdac dbca
 * 输出：abdc
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String s1 = split[0];
        String s2 = split[1];
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        TreeNode treeNode = buildTree(chars1, chars2);
        helper(treeNode, list);
        for (char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static TreeNode buildTree(char[] inorder, char[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, postorder);
    }

    private static TreeNode helper(char[] in, char[] post) {
        if (in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(post[post.length - 1]);
        for (int i = 0; i < in.length; ++i) {
            if (in[i] == post[post.length - 1]) {
                char[] inLeft = Arrays.copyOfRange(in, 0, i);
                char[] inRight = Arrays.copyOfRange(in, i + 1, in.length);
                char[] postLeft = Arrays.copyOfRange(post, 0, i);
                char[] postRight = Arrays.copyOfRange(post, i, post.length - 1);
                root.left = helper(inLeft, postLeft);
                root.right = helper(inRight, postRight);
                break;
            }
        }
        return root;
    }

    private static void helper(TreeNode root, List<Character> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}
