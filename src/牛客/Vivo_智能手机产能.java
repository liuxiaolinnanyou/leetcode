package 牛客;

/**
 * 在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
 * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
 * 以此类推，请编程计算出第n天总共可以量产的手机数量。
 * <p>
 * 输入11  输出35    说明：第11天工人总共可以量产的手机数量
 */
public class Vivo_智能手机产能 {
    public static void main(String[] args) {
        System.out.println(solution(11));
        System.out.println(solution2(4));
    }

    // 方法 1
    public static int solution(int n) {
        int ans = 0;
        for (int i = 1; n > 0; ++i) {
            ans += i * Math.min(i, n);
            n -= i;
        }
        return ans;
    }

    // 方法 2
    public static int solution2(int n) {
        int sum = 0;
        int tem = 1;
        for (int i = 1; i <= n; ) {      // 外循环控制天数
            for (int j = 1; j <= tem && i <= n; j++) {     // 内循环控制每天的产能
                sum += tem;
                i++;
            }
            tem++;
        }
        return sum;
    }
}
