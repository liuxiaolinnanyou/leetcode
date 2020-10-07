package 十三轮;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class 数组中的第k个最大元素 {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arr1, 2));
        System.out.println(findKthLargest(arr2, 4));
    }

    // 方法1 先排序然后输出 k-1 位置的元素
    public static int findKthLargest(int[] nums, int k) {
        // 求第 K 大或第 K 小，一般思路就是构建一个只有 k 个节点的堆，最后返回堆顶。
        // Java 里面堆可以用 PriorityQueue，默认是小顶堆，如果要实现大顶堆的话，要重写它的 comparator
        // 我这里用了 Java API，也提供了自己创建堆的代码。
        // 默认小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (num > heap.peek()) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.peek();
    }

    // 快速排序的思想
    public int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            // 第一次做 partition 得到的下标位置
            int index = partition(nums, left, right);
            if (index == k - 1) {
                return nums[index];
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotIndex = right;
        while (left < right) {
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            // 交换 pivot 和
            swap(nums, left, right);
        }
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}