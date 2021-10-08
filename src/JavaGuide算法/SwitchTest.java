package JavaGuide算法;

public class SwitchTest {
    public static void main(String[] args) {
        String s = "mengmeng";
        switch (s) {
            default:
                System.out.println("default:默认退出。");
                break;
            case "meng":
                System.out.println("少一个蒙那就不是蒙！");
            case "siyu":
                System.out.println("这是小姨子！");
            case "mengmeng":
                System.out.println("恭喜，这就是她，only one！");
        }
    }
}