package Experience;

/**
 * Created by apple on 17/4/4.
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 解题思路：
 采用中序遍历， 二插搜索树的中序遍历应该是递增序列，当前节点的值大于上一个节点的值，
 因此我们保存上一个节点的值为prevElement,如果当前节点值< prevElement,则记录下来
 这道题要注意： 负数的情况
 */
public class RecoverBinarySearchTree {
    TreeNode firstElement = null, secondElement = null;
    TreeNode preElement = new TreeNode(Integer.MIN_VALUE); // 要设置成最小值，有负数的情况

    public void recoverTree(TreeNode root) {
        if (root == null) return ;
        traverse(root);
        // swap the value of two node
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) return ;
        traverse(root.left);
        // do something here
        if (firstElement == null && preElement.val > root.val) {
            firstElement = preElement;
        }
        if (firstElement != null && preElement.val > root.val) {
            secondElement = root;
        }
        preElement = root;
        traverse(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int x) {
        val = x;
    }
}