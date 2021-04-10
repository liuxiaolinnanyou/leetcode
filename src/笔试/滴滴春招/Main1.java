package 笔试.滴滴春招;

// java  AC 55
/**
 * 小A的家门口有一排树，每棵树都有一个正整数的高度。由于树的高度不同，来到小A家的朋友都觉得很难看。
 * 为了将这些树高度变得好看，小A决定对其中某些树施展魔法，具体来说，每施展一次魔法，可以把一棵树的高度
 * 变成任意正整数（可以变高也可以变低）。小A认为，这排树如果能构成等差数列就好看了，但是小A不想施展太多次
 * 魔法，他想知道最少施展魔法的次数。
 * <p>
 * 输入：
 * 5 2  第一个数是树的棵树  第二个数为公差
 * 1 3 1 3 5
 * 输出：
 * 3
 * <p>
 * 对3,4,5号树施法，最后变为1,3,5,7,9
 */

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min = 0;
            if ((arr[i] - i * x) < 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (arr[j] != arr[i] + (j - i) * x) {
                    min++;
                }
            }
            res = Math.min(res, min);
        }
        System.out.println(res);
    }
}


// AC 100
//class Solution:
//        def __init__(self, n, x, a):
//            self.n, self.x = n, x
//            self.a = a    # [0, 1, 2, 2, 1, 0]
//            self.mp = {}
//
//        def solve(self):
//            ans = 100010
//            for idx, ai in enumerate(self.a):
//                if ai - idx * self.x <= 0:
//                    continue
//                if ai - idx * self.x not in self.mp:
//                    self.mp[ai - idx * self.x] = 1
//                else:
//                    self.mp[ai - idx * self.x] += 1
//                ans = min(ans, self.n - self.mp[ai - idx * self.x])
//
//            return ans
//
//
//        if __name__ == "__main__":
//            n, x = [int(x) for x in input().split()]
//            a = [int(x) for x in input().split()]
//            S = Solution(n, x, a)
//            print(S.solve())