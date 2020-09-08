package newcoder_剑指offer;

import java.util.ArrayList;

// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
// 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
public class 字符串的排列 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permutation(s));
//        System.out.println(permutation("ccc"));
    }

    // 递归
    public static ArrayList<String> permutation(String str) {
        StringBuilder strBuilder = new StringBuilder(str);    // 把string转成stringbuilder
        ArrayList<String> result = permutationHelp(strBuilder);
        return result;
    }

    public static ArrayList<String> permutationHelp(StringBuilder str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str.length() == 1) {
            result.add(str.toString());             // 字符串长度为 1
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || str.charAt(i) != str.charAt(0)) {
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = permutationHelp(new StringBuilder(str.substring(1)));
                    for (int j = 0; j < newResult.size(); j++) {
                        result.add(str.substring(0, 1) + newResult.get(j));
                    }
                    // 用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
        }
        return result;
    }


    /**
     * // String的用法：
     * // java中String是只读的，没有办法进行变换，因此需要使用StringBuilder。
     * String.length() //获取字符串的长度
     * String.charAt(i) //获取第i个字符的内容
     * String.subString(start)   //获取[start,）的字符串
     * String.subString(start,end) //获取[start,end）中的字符串
     * char[] c = iniString.toCharArray() //将字符串转为char数组来进行改变字符内容
     * String.equal() //判断两个字符串是否相等
     *
     * // StringBuilder的用法：
     * 除了String中支持的方法外，StringBuilder支持字符的增、删、改。
     * stringBuilder.append("we");            // 添加we在词尾
     * stringBuilder.insert(0,"we");          // 在0的位置加入后面的内容
     * stringBuilder.delete(0,1);             // 删除[0,1)的数据
     * stringBuilder.deleteCharAt(0);
     * stringBuilder.setCharAt(0,'p');        // 在某一个独特位置设置字符
     * char c = stringBuilder.charAt(i);      // 查询某个位置上的字符
     * System.out.println(stringBuilder);
     * new String(stringBuilder);             // 用stringBuilder来初始化String
     */
}