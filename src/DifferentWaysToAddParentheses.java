import java.util.*;
/**
 * Created by apple on 17/3/10.
 *
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '-') {

                List<Integer> listL = diffWaysToCompute(input.substring(0, i));
                List<Integer> listR = diffWaysToCompute(input.substring(i + 1));

                for (int x : listL) {
                    for (int y : listR) {
                        if (c == '+')
                            list.add(x + y);
                        else if (c == '-')
                            list.add(x - y);
                        else if (c == '*')
                            list.add(x * y);
                    }
                }
            }
        }
        // 截止情况
        if (list.size() == 0)
            list.add(Integer.valueOf(input));
        return list;
    }
    public static void main(String[] args) {
        DifferentWaysToAddParentheses mySolution = new DifferentWaysToAddParentheses();
        String str = "2*3-4*5";
        List<Integer> list = mySolution.diffWaysToCompute(str);
        System.out.println(list);
    }
}
