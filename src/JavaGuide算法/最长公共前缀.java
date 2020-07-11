package JavaGuide算法;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串""。
 * {"flower","flow","flight"}    输出："fl"
 * {"dog","racecar","car"}       输出：""
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"customer", "car", "cat"};
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));      // 注意字符串数组的排序规则

//        System.out.println(replaceSpace(strs));
//        System.out.println("-----------------------分隔符-----------------------");
//
//        String[] strs2 = {"customer", "car", null};
//        String[] strs3 = {};
//        String[] strs4 = null;
//        String[] strs5 = {"flower", "flow", "flight"};
//        System.out.println(replaceSpace(strs2));
//        System.out.println(replaceSpace(strs3));
//        System.out.println(replaceSpace(strs4));
//        System.out.println(replaceSpace(strs5));
    }

    public static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    // 只要有不满足的就直接退出
                    break;
                }
            }
        }
        return flag;
    }

    public static String replaceSpace(String[] strs) {
        // 如果检查值不合法就返回空串
        if (!checkStrs(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder sb = new StringBuilder();
        // 给字符串数组的元素按照长度升序排序
        Arrays.sort(strs);   // 找出字符串数组中字符串的最大长度和最小长度
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {   // 只需要比较排序后的第一个和最后一个
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}