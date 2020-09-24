package 测试5;

public class Test1 {
    public static void main(String[] args) {
        String str = "Hello World, Hello China, Hello Beijing.";
        int index = str.indexOf("China");
        if (index == -1) {
            System.out.println("查找的字符不存在");
        } else {
            System.out.println("index:" + index);
        }
    }
}