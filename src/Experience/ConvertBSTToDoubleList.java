package Experience;

/**
 * Created by apple on 17/3/21.
 * 剑指Offer 面试题： 27
 * 注意事项： 双向链表
 * BST有顺序
 *
 */
public class ConvertBSTToDoubleList {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode convert(TreeNode root) {
        TreeNode last = null;
        convertNode(root, last);
        return root;
    }
    private void convertNode(TreeNode root, TreeNode last) {
        if (root == null)
            return ;
        if (root.left != null) { // 如果左子树非空递归调用
            convertNode(root.left, last);
        }
        root.left = last; // 将链表中最后一个复制给root.left
        if (last != null) // 如果链表末尾非空，则将链表末尾右侧指向根节点
            last.right = root;
        last = root;
        if (root.right != null)
            convertNode(root.right, last);
    }
}
