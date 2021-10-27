package 大华技术股份;

/**
 * 解码自适应
 * 在NVR等后端设备中，主控芯片解码能力有限，当进行多画面预览时，如果解码能力不足会自动切换辅码流进行预览，
 * 如果全部切换辅码流分辨率后能力还不够，则显示黑屏
 * 给出N个通道的辅码流分辨率及帧率，求最多能解码多少路。
 * 总能力C是一个正整数，每个通道的解码能力是分辨率宽*高*帧率
 * <p>
 * 输入：
 * 第一行输入n c表示当前预览有n个窗口(n <=128)，总解码能力为c
 * 接下来每行输入w*h f，表示每个通道的分辨率和帧率
 * w表示宽，h表示高，f表示帧率（测试数据中都是正整数）
 * 输出：
 * 输出当前预览界面中最多能够解码显示多少路
 * <p>
 * <p>
 * 样例
 * 输入：
 * 4 212336640
 * 176*144 25
 * 176*144 25
 * 640*480 25
 * 160*128 25
 * 输出：
 * 4
 * 提示：
 * 176*144*25+176*144*25+640*480*25+160*128*25<212336640
 * 所以所有通道都可以正常解码显示
 */
public class Main3 {
    public static void main(String[] args) {

    }
}
