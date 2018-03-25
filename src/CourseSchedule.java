import java.util.*;

/**
 * Created by maria on 17-7-27.
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]

 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]

 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.

 click to show more hints.
 Hints:

 This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.

 题目注意事项：
 DAG：direct acyclic graph
 思考：
 这道题第一个变量其实没有什么用
 */
public class CourseSchedule {

    /**
     *  方法一: O(n)自己想的
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish_A(int numCourses, int[][] prerequisites) {
        // 1. 构建一个topology map
        if (prerequisites == null || numCourses <= 0 || prerequisites[0].length == 0) return false;
        if (prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                map.put(prerequisites[i][0], new ArrayList<>());
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        // 2. search topology map, find if there exists a not DAG
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        for (int k : map.keySet()) {
            if (visit(k, map, stack, set) == false) return false;
        }
        return true;
    }
    public static boolean visit(int k, HashMap<Integer, List<Integer>> map, Stack<Integer> stack, Set<Integer> set) {
        if (stack.contains(k)) return true;
        if (set.contains(k)) return false;
        set.add(k);
        if (map.containsKey(k)) {
            for (int l : map.get(k)) {
                if (!visit(l, map, stack, set)) return false;
            }
        }
        stack.add(k);
        return true;
    }

    /**
     *  方法二：效率最高
     * @param
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Make a graph that u point to v, if u is a prerequisite of v
        List<List<Integer>> graph = makeGraph(numCourses, prerequisites);
        boolean[] onePath = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && bfs(graph, i, onePath, visited)) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> makeGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // xToY[0] depends on xToY[1]
        for (int[] xToY: prerequisites) {
            graph.get(xToY[1]).add(xToY[0]);
        }
        return graph;
    }

    private boolean bfs(List<List<Integer>> graph, int node, boolean[] onePath, boolean[] visited) {
        if (visited[node]) return false;
        onePath[node] = true;
        visited[node] = true;
        List<Integer> edges = graph.get(node);
        for (int endPoint: edges) {
            if (onePath[endPoint] || bfs(graph, endPoint, onePath, visited)) {
                return true;
            }
        }
        onePath[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {5, 1}, {2, 6}};
        System.out.println(canFinish_A(6, prerequisites));
    }

}
