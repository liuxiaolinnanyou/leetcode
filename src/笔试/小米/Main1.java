package 笔试.小米;

import java.util.Scanner;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中，相邻单元格是那些水平相邻或者垂直相邻的单元格，同一个单元格内的字母
 * 不允许被重复使用。 true代表存在   false代表不存在
 * <p>
 * [
 * [A B C E]
 * [S F C S]
 * [A D E E]
 * ]
 * <p>
 * 输入：SEE
 * 输出：true
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        if (s == null || s.length() == 0) {
            System.out.println(false);
            return;
        }
        System.out.println(exist(chars, s));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, visited, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int i, int j, int idx, String word, boolean[][] visited, char[][] board) {
        if (idx == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (backtrack(i + 1, j, idx + 1, word, visited, board) || backtrack(i - 1, j, idx + 1, word, visited, board) || backtrack(i, j + 1, idx + 1, word, visited, board) || backtrack(i, j - 1, idx + 1, word, visited, board)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}

