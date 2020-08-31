package 笔试.小红书;

import java.util.Arrays;
import java.util.Comparator;

// AC 100

/**
 * 嵌套盒子
 * 小明情人节想给女朋友送一束花，但是他想给女朋友开个玩笑，于是找来很多高度和直径不等的圆柱形包装盒，一层一层的包装花
 * 即先用一个小盒子包装花，再用一个稍大的盒子包装小盒子，以此类推，要求外面的盒子高度和直径都大于里面一层的盒子，给出所有的
 * 盒子数据，求最多能包装多少个盒子，假设花可以装进最小的盒子。
 * <p>
 * 输入：
 * 6
 * 2
 * 100 65
 * 150 70
 * 90 56
 * 190 75
 * 95 60
 * 110 68
 * 输出：
 * 6
 */
public class Main1 {
    public static void main(String[] args) {

    }

    public static int maxBoxes(int[][] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int len = boxes.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
