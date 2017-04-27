import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    if (i > 0)
                        temp.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }

            }
            list.add(new ArrayList<>(temp));
        }
        return list;
    }

    public static List<List<Integer>> generate_B(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {

            temp.add(0, 1); // 每一行，都先添加1
            for (int j = 1; j < temp.size() - 1; j++) {
                temp.set(j, temp.get(j) + temp.get(j + 1));
            }
            list.add(new ArrayList<>(temp));
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(generate_B(n));
    }

}
