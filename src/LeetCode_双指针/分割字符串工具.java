package LeetCode_双指针;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class 分割字符串工具 {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        StringTokenizer st = new StringTokenizer("Welcome to our country");
//        while (st.hasMoreTokens()) {
//            System.out.println(st.nextToken());
//        }

        String s1 = "中国";
        String s2 = "china";
        byte[] bytes1 = s1.getBytes();
        byte[] bytes2 = s2.getBytes();

        byte[] bytes3 = s1.getBytes("utf-8");
        byte[] bytes4 = s2.getBytes("utf-8");

        byte[] bytes5 = s1.getBytes("gbk");
        byte[] bytes6 = s2.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
        System.out.println(Arrays.toString(bytes3));
        System.out.println(Arrays.toString(bytes4));
        System.out.println(Arrays.toString(bytes5));
        System.out.println(Arrays.toString(bytes6));
        System.out.println("---------------------");

        System.out.println(new String(bytes3, "utf-8"));
        System.out.println(new String(bytes3, "gbk"));
        System.out.println(new String(bytes5, "utf-8"));
        System.out.println(new String(bytes5, "gbk"));
    }
}
