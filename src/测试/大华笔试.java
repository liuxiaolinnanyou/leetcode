package 测试;

/**
 * 一个文件中包含多个字符串，每个字符串独立一行，要求将输入文件input.txt中的字符串进行排序，
 * 排序后输出到out.txt文件
 */

import java.io.*;
import java.util.*;

public class 大华笔试 {
    public static void main(String[] args) {
        BufferedReader bfr = null;
        FileWriter out = null;
        try {
            FileReader read = new FileReader("input.txt");
            out = new FileWriter("output.txt");
            bfr = new BufferedReader(read);
            ArrayList<String> list = new ArrayList<>();
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
                list.add(line);
            }
            Collections.sort(list);
            for (String str : list) {
                out.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfr != null) {
                    bfr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}