package 二叉树;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * {3,4,9,5,12,11,10}
 * <p>
 * 一颗 BST：左孩子 < 根节点 < 右孩子
 * 一颗 BST 的左子树或者右子树都是 BST
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 5, 12, 11, 10};
        System.out.println(VerifySequenceOfBST(arr));
    }

    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helpVerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean helpVerifySequenceOfBST(int[] sequence, int start, int root) {
        if (start >= root) {
            return true;
        }
        int key = sequence[root];
        int i;
        // 找到左右子树的分界点
        for (i = start; i < root; i++) {
            if (sequence[i] > key) {
                break;
            }
        }
        // 在右子树中判断是否含有小于 root 的值，如果有返回 false
        for (int j = i; j < root; j++) {
            if (sequence[j] < key) {
                return false;
            }
        }
        return helpVerifySequenceOfBST(sequence, start, i - 1) && helpVerifySequenceOfBST(sequence, i, root - 1);
    }
}