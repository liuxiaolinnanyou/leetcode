package newcoder_剑指offer;

// 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
// 比如n=3时，2*3的矩形块有3种覆盖方法：
public class 覆盖矩形块 {
    public static void main(String[] args) {
        System.out.println(rectCover(3));
    }

    public static int rectCover(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }
}
