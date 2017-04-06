import java.util.*;
/**
 * Created by apple on 17/4/5.
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 解题思路：
 这道题是三角形，因此我们可以想象成Tree,
 从下往上走，倒数第二行保存的是当前列的数值 + 倒数第一行的两个子节点的最小值
 */
public class Triangle {
    /*
        方法一： Bottom - up 算法
        采用一维数组A[j] 保存的是当前的列的最小值
     */
    public static int minimumTotal_B(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];

        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            int m = triangle.get(i).size();
            for (int j = 0; j < m; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
    public static void main(String[] args) {
        List<List<Integer>> list;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            list = new ArrayList<>();
            int n = Integer.parseInt(in.nextLine()); // num of row in the triangle
            while (n-- != 0) {
                String[] str = in.nextLine().split(" ");
                List<Integer> temp = new ArrayList<>();
                for (String s : str) {
                    temp.add(Integer.parseInt(s));
                }
                list.add(temp);
            }
            System.out.println(minimumTotal_B(list));
        }

    }

}
