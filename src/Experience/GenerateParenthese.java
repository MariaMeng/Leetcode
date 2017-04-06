package Experience;
import java.util.*;
/**
 * Created by apple on 17/3/29.
 */
public class GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return ;
        }
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        Scanner my = new Scanner(System.in);

        int n = my.nextInt();
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];
        for (int i = 0; i < a.length; i++) {
            a[i] = my.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = my.nextInt();
        }

        GenerateParenthese g = new GenerateParenthese();
        List<String> list = g.generateParenthesis(n);
        long sum = 0;
        long max = 0;
        for (String s : list) {
            sum = 0;
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '(') {
                    sum += a[i];
                } else
                    sum += b[i];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }

}
