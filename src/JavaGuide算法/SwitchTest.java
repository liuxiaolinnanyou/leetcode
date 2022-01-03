package JavaGuide算法;

/**
 * 表达式的取值byte、short、int、char，JDK5以后可以是枚举，JDK7以后可以是字符串。
 */
public class SwitchTest {
    public static void main(String[] args) {
        String s = "mengmeng";
        switch (s) {
            default:
                System.out.println("default:默认退出。");
                break;
            case "meng":
                System.out.println("少一个蒙那就不是蒙！");
                break;
            case "siyu":
                System.out.println("这是小姨子！");
                break;
            case "mengmeng":
                System.out.println("恭喜，这就是她，only one！");
                break;
            case "otherwise":
                System.out.println("这都猜不到？");
                break;
        }
    }
}