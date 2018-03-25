/**
 * Created by maria on 17-11-8.
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int l = edge[0];
            int r = edge[1];
            int parent_l = Find(parent, l);
            int parent_r = Find(parent, r);

            if (parent_l == parent_r)
                return edge;
            else {
                /*
                    To merge components containing p and q, set the root of p with the root of q.
                 */
                parent[parent_l] = parent_r;
            }
        }
        return new int[2];
    }
    public int Find(int[] parent, int now) {
        if (parent[now] != now) {
            parent[now] = Find(parent, parent[now]);
        }
        return parent[now];
    }
}
