package Experience;

/**
 * Created by apple on 17/3/19.
 * 剑指Offer 面试题 18
 */
public class IsSubTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasSubTree(TreeNode t1, TreeNode t2) {
        boolean result = false;
        if (t1 != null && t2 != null) {
            if (t1.val == t2.val)
                result =  doesTree1HasTree2(t1, t2);
            if (!result) // 如果没有，则在左子树寻找
                result = hasSubTree(t1.left, t2);
            if (!result) // 如果没有，则在右子树上寻找
                result = hasSubTree(t1.right, t2);
        }
        return result;
    }
    private boolean doesTree1HasTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) // if pattern tree is null, that means all the tree in pattern t2 has been matched
            return true;
        if (t1 == null) // if t1 is null
            return false;
        if (t1.val != t2.val) // if the root of two tree does not match with each other
            return false;
        return doesTree1HasTree2(t1.left, t2.left) && doesTree1HasTree2(t1.right,t2.right);
    }
}
