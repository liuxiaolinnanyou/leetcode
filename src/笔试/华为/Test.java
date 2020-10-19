package 笔试.华为;

public class Test {
    public static void main(String[] args) {
        String s = "[12 13 15 17][14 16 18]";
        String[] split = s.split("]\\[");    // 分割 "][" 时的注意事项，浦发银行笔试在这里吃了亏
        System.out.println(split[0]);
        System.out.println(split[1]);
    }
}