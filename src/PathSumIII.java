import java.util.HashMap;

/**
 * Created by apple on 17/4/21.
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf,
 but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 解题思路：
 已知一个Tree, 一个target值。求组合成这个值的path的条数
 采用与Two Sum 一致的方法。
 使用HashMap + DFS
 在map中记录PrefixSum以及num of ways的个数
 如果 PrefixSum - target 在map中存在，则count++
 注意事项：
 map(0, 1)一定要写，代表的是prefix sum = 0时，个数为1.
 如果后来有从根节点出发的路径上，满足 prefixSum = target时， 在进行 prefixSum - target = 0 时有用。
 */
public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 这一步很关键！！
        helper(root, 0, sum, map);
        return count;
    }
    private void helper(TreeNode root, int curSum, int target, HashMap<Integer,Integer> map) {
        if (root == null) return ;
        curSum += root.val; // 注意这一步很关键！！
        if (map.containsKey(curSum - target)) {
            count += map.get(curSum - target);
        }
        if (map.containsKey(curSum)) {
            map.put(curSum, map.get(curSum) + 1);
        } else
            map.put(curSum, 1);
        helper(root.left, curSum, target, map);
        helper(root.right, curSum, target, map);
        map.put(curSum, map.get(curSum) - 1); // 注意这一步很关键！！
    }
}
