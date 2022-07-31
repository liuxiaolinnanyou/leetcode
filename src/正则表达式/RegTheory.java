package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分析java的正则表达式的底层实现原理
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台" +
                "（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；" +
                "J2SE（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），" +
                "应用3443于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及9889。";
        // 目标：匹配所有4个数字
        // 说明：\\d 表示一个任意的数字
//        String regStr = "\\d\\d\\d\\d";
        String regStr = "(\\d\\d)(\\d\\d)";   // 分组的情况
        // 创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        // 创建匹配器 （按照正则表达式的规则去匹配 content 字符串）
        Matcher matcher = pattern.matcher(content);
        // 开始匹配
        /**
         * matcher.find() 完成的任务
         * 1.根据指定的规则，定位满足规则的子字符串(比如：1998)
         * 2.找到后，将子字符串的开始的索引记录到 matcher 对象的属性 int[] groups
         *   groups[0] = 0,把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         * 3.同时记录 oldLast 的值为 子字符串的结束的 索引+1的值 即4  即下次执行find()时就从4开始匹配
         *
         * 源码：
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         * }
         * 1.根据 groups[0] 和 groups[1] 的记录的位置，从content开始截取子字符串返回(0-4)   [0,4)
         *
         * 如果再次执行find()方法，仍然按照上面的分析来执行   groups[0] = 31  groups[1] = 35
         */
        /**
         * 2.分组
         * 比如 (\\d\\d)(\\d\\d)  正则表达式中有小括号就表示分组，第一个括号表示第一组，第二个括号表示第二组...
         *      1.1 groups[0] = 0,把该子字符串的结束的索引+1的值记录到 groups[1] = 4
         *      1.2 记录第一组括号匹配到的字符串 groups[2] = 0   groups[3] = 2
         *      1.3 记录第二组括号匹配到的字符串 groups[4] = 2   groups[5] = 4
         *      1.4 如果有更多的分组，以此类推。
         *      看不懂的话  走 debug
         */
        while (matcher.find()) {
            // 小结
            // 1.如果正则表达式有() 即分组 取出匹配的字符串规则如下
            // 2.group[0]  表示匹配到的整体的子字符串
            // 3.group[1]  表示匹配到的子字符串的第一组
            // 4.group[2]  表示匹配到的子字符串的第二组
            // 但是分组数不能越界    java.lang.IndexOutOfBoundsException: No group 3
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第一组()：" + matcher.group(1));
            System.out.println("第二组()：" + matcher.group(2));
//            System.out.println("第三组()：" + matcher.group(3));
        }
    }
}