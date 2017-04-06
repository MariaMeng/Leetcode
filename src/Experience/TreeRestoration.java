package Experience;
import java.util.*;
/**
 * Created by apple on 17/3/31.
 */
public class TreeRestoration {
    class TreeNode {
        List<TreeNode> children;
        int val;
        public TreeNode(int x) {
            val = x;
        }
    }
    TreeNode root;
    public TreeRestoration(int x) {
        root = new TreeNode(x);
    }

    public static void main(String[] args) {
        Scanner my = new Scanner(System.in);
        int N = my.nextInt(); // number of node
        int M = my.nextInt(); // number of deep
        int K = my.nextInt(); // num of leaves

        int[] deep = new int[M];
        for (int i = 0; i < M; i++) {
            deep[i] = my.nextInt();
        }

        int[] node = new int[N];
        for (int i = 0; i < N; i++) {
            node[i] = my.nextInt();
        }

        int[] leaves = new int[K];
        for (int i = 0; i < K; i++) {
            leaves[i] = my.nextInt();
        }

        int[][] array = new int[K][K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                array[i][j] = my.nextInt();
            }
        }
        TreeRestoration tr = new TreeRestoration(node[0]);

    }
    public void insert(int[] node, int[] deep, int[] leave, int[] array) {

    }
}
