package 笔试.锐明技术;

import java.util.ArrayList;

/**
 * n 个人围成一圈，从 1 开始按序号排序，从第一个人开始报数(从1到3报数)，凡报到3的退出圈子，问最后留下的是原来第几号的那位。
 * <p>
 * 输入：4
 * 输出：1
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(reportNumber(4));
        System.out.println(reportNumber(6));
    }

    public static int reportNumber(int totalNumber) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 1; j <= totalNumber; j++) {
            list.add(j);
        }
        int id = 0;
        while (totalNumber > 1) {
            id = (id + 2) % totalNumber;
            list.remove(id);
            totalNumber--;
        }
        return list.get(0);
    }
}