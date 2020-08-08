package 八轮;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 * <p>
 * 输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * <p>
 * 输入只包含小写字母。
 * 1 <= dict.length <= 1000
 * 1 <= dict[i].length <= 100
 * 1 <= 句中词语数 <= 1000
 * 1 <= 句中词语长度 <= 1000
 */
public class 单词替换 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
//        Collections.sort(list);
//        System.out.println(list);
        String s = "the cattle was rattled by the battery";
        System.out.println(replaceWords(list, s));
    }

    // 自己写的
    public static String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict);
        String[] split = sentence.trim().split(" ");
        for (int i = 0; i < split.length; i++) {
            for (String s : dict) {
                if (split[i].startsWith(s)) {
                    split[i] = s;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // 还有一种解法   前缀树
}
