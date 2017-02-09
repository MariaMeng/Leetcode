import java.util.*;

/**
 * Created by apple on 17/2/7.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 注意：backtrack回溯题目进行分析时，要画状态图，包括每个状态的i的变化
 需要维护左括号、右括号两个count
 */
public class GenerateParentheses {
    /*
        方法一： 采用回溯方法，通过不断递归完成。
                回溯法（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。
                但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，
                这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    /*
        方法二： 采用动态规划方法
     */
    public List<String> generateParenthesis_B(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }
    public static void main(String[] args) {
        GenerateParentheses mySolution = new GenerateParentheses();
        int n = 3;
        List<String> list = mySolution.generateParenthesis(3);
        System.out.println(list);
        List l = Collections.singletonList("string");

    }
}

