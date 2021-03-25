package 笔试.阿里;

import java.util.TreeSet;

public class Main3 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Integer> subSet = new TreeSet<>();
        for (int i = 606; i < 613; i++) {
            if (i % 2 == 0) {
                set.add(i);
            }
        }
        subSet = (TreeSet) set.subSet(608, true, 611, true);
        set.add(629);
        System.out.println(set + " " + subSet);
    }
}
