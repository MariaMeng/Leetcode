import java.util.*;
/**
 * Created by apple on 17/3/11.
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].
 */
public class CountOfSmallerNumbersAfterSelf {
    /*
        方法一： 采用Binary Search Tree方法
        从后往前依次插入一个元素，从而构建一个BST树。
     */
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node root, Integer[] ans, int i, int preSum) {
        if (root == null) {
            root = new Node(num, 0);
            ans[i] = preSum;
        } else if (root.val == num) {
            root.dup++;
            ans[i] = preSum + root.sum;
        } else if (root.val > num) {
            root.sum++;
            root.left = insert(num, root.left, ans, i, preSum);
        } else {
            root.right = insert(num, root.right, ans, i, preSum + root.dup + root.sum);
        }
        return root;
    }

    class Node{
        Node left, right;
        int val;
        int sum;
        int dup = 1;
        public Node(int val, int sum) {
            this. val = val;
            this. sum = sum;
        }
    }

    /*
        方法二： 采用归并排序的方法
        Time Complexity : O(n log n)
        Space Compexity: O(n)
        注意事项：
        cache中保存的是下标，按照对应内容的大小排序，元素数值小，则地址放前
     */
    int[] count; // 定义一个成员变量
    public List<Integer> countSmaller_B(int[] nums) {
        List<Integer> res = new ArrayList<>();
        count = new int[nums.length];

        int[] pos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pos[i] = i;
        }
        mergesort(nums, pos, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] pos, int left, int right) {
        if (right <= left) return ;
        int mid = (left + right) / 2;
        mergesort(nums, pos, left, mid);
        mergesort(nums, pos, mid + 1, right);

        merge(nums, pos, left, right);
    }
    private void merge(int[] nums, int[] pos, int left, int right) {
        int mid = (left + right) / 2;
        int leftIndex = left; // left
        int rightIndex = mid + 1; // right
        int sortedIndex = 0; // sorted index
        int rightCount = 0; // 在右侧的数组中，需要移动到该数（左侧数组）前面的个数,

        int[] cache = new int[right - left + 1];
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[pos[rightIndex]] < nums[pos[leftIndex]]) { // 如果右侧小于左侧数值
                rightCount++; // 每次右侧比左侧大，都要移动
                cache[sortedIndex++] = pos[rightIndex++];
            } else { // 如果右侧大于左侧
                count[pos[leftIndex]] += rightCount;
                cache[sortedIndex++] = pos[leftIndex++];
            }
        }
        while (leftIndex <= mid) { //左边还有剩余的元素没有遍历完
            count[pos[leftIndex]] += rightCount; //下标位置标记，这种情况吧所有未便利完的都标记
            cache[sortedIndex++] = pos[leftIndex++];
        }
        while (rightIndex <= right) { //右边还有剩余元素没遍历完
            cache[sortedIndex++] = pos[rightIndex++];
        }
        for (int p = 0; p < cache.length; p++) {
            pos[left + p] = cache[p];
        }
    }
}
