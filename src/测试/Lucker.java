package 测试;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lucker {
    static String[] name = {"刘德华", "潘长江", "林允儿", "迪丽热巴", "古力娜扎", "金晨", "刘诗诗", "柳岩", "石原里美", "深田咏美"};
    static int num = 3;

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (; ; ) {
            if (set.size() == num) {
                break;
            }
            int random = new SecureRandom().nextInt(name.length);
            set.add(name[random]);
        }
        Iterator<String> iterator = set.iterator();
        System.out.println("抽奖活动现在开始：");
        System.out.println("开奖人：刘晓林");
        System.out.println("恭喜这些逼：");
        while (iterator.hasNext()) {
            System.out.printf("中iphone11 pro的人是：%s\r\n", iterator.next());
        }
        System.out.println("中奖的人请与我联系。");
    }
}
