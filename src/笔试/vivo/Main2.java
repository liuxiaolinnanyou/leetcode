package 笔试.vivo;

import java.util.HashSet;
import java.util.Set;

/**
 * 编译依赖问题
 * 假设有 0 , 1 , 2 , 3 四个文件，0 号文件依赖 1 号文件，1 号文件依赖 2 号文件，3 号文件依赖 1 号文件，则源文件的
 * 编译顺序为 2 , 1 , 0 , 3 或 2 , 1 , 3 , 0。现给出文件依赖关系，如 1 , 2 , -1 , 1，表示 0 号文件依赖 1 号文件，
 * 1 号文件依赖 2 号文件，2 号文件没有依赖，3 号文件依赖 1 号文件。
 * 注意，如有同时可以编译多个文件的情况，按数字升序返回一种情况即可，比如前述案例输出位：2 , 1 , 0 , 3
 * <p>
 * 输入："1,2,-1,1"
 * 输出："2,1,0,3"
 * -1表示当前文件没有依赖，输出结果用英文逗号分隔，暂不考虑一个文件依赖多个文件的情况。
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(compileSeq("1,2,-1,1"));
    }

    public static String compileSeq(String input) {
        // write code here
        String[] strs = input.split(",");
        int len = strs.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (set.contains(nums[j]) || nums[j] == -1) {
                    set.add(j);
                    sb.append(j);
                    sb.append(",");
                    nums[j] = -2;
                    break;
                }
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}