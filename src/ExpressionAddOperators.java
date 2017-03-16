import java.util.*;
/**
 * Created by apple on 17/3/15.
 * Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 注意：
 1. 这道题数可能很大， 超过int最大值
 2. 长度大于1且首字符是‘0’的字符串，将其滤去即可，这一步非常关键！！
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num == null || num.length() == 0) return list;
        helper(list, "", num, target, 0,  0, 0);
        return list;
    }
    private void helper(List<String> list, String path, String num, int target, int pos, long eval, long multi) {
        if (pos == num.length()) {
            if (target == eval) list.add(path);
        } else {
            for (int i = pos; i < num.length(); i++) {
                if (num.charAt(pos) == '0' && i != pos) break; // 这一步非常关键
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0)
                    helper(list, path + cur, num, target, i + 1, cur, cur);
                else {
                    helper(list, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                    helper(list, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                    helper(list, path + "*" + cur, num, target, i + 1, eval - multi + multi * cur, multi * cur);
                }
            }
        }
    }
}
