package 笔试.声网;

public class ASCII {
    public static void main(String[] args) {
        for (int i = 0; i < 255; i++) {
            char ch = (char) i;
            System.out.println(ch + " " + i);
        }
    }
}