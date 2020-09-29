package 笔试.五八同城;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[m];
        for (int i = 0; i < m; i++) {
            str[i] = sc.nextLine();
        }
        char[][] ch = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[] split = str[i].split(" ");
            for (int j = 0; j < n; j++) {
                ch[i][j] = split[j].charAt(0);
            }
        }
        Main main = new Main();
        System.out.println(main.numIslands(ch));
    }

    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
