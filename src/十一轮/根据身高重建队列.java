package 十一轮;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 * k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = reconstructQueue(arr);
        for (int[] a : queue) {
            System.out.print(Arrays.toString(a));
        }
    }

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先 H 高度降序，K 个数升序排序
     * 2.遍历排序后的数组，根据 K 插入到 K 的位置上
     * 核心思想：高个子先站好位，矮个子插入到 K 位置上，前面肯定有 K 个高个子，矮个子再插到前面也满足 K 的要求
     */
    public static int[][] reconstructQueue(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]

        // 两数不等，按照左边数降序，两边相等，按照右边数升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        // 返回新数组，注意设置长度 几行 2 列
//        return list.toArray(new int[list.size()][2]);
        return list.toArray(people);
    }
}
