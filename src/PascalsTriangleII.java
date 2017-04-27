import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1); // 每一行，都先添加1
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getRow(n));
    }

}
