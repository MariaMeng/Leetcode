import java.util.*;
/**
 * Created by apple on 17/4/6.
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 Please reload the code definition to get the latest changes.
 解题思路：
 题意： 字典中没有重复单词， 判断给定的字符串是否能被分割成字典中的一个或者多个单词。
 这道题：有一个回溯的过程
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0 || s == null || s.length() == 0) return false;
        int i = -1, j = 1;
        int n = s.length();
        while (j <= n) {
            String temp = s.substring(i + 1, j);
            if (wordDict.contains(temp)) {
                i = j - 1;
                wordDict.remove(temp);
            }
            j++;
        }
        return i == n - 1;
    }

    public boolean wordBreak(String s, Set<String> dict){
        boolean[] t =new boolean[s.length()+1];
        t[0]=true;//set first to be true, why?
        //Because we need initial state

        for(int i=0; i < s.length(); i++){
            //should continue from match position
            if(!t[i]) // 如果当前值为true,则直接过去
                continue;

            for(String a: dict){
                int len = a.length(); // word 长度
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end]=true;
                }
            }
        }

        return t[s.length()];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            List<String> list = new ArrayList<>();
            int n = in.nextInt(); // num of words in dic
            while (n-- != 0) {
                list.add(in.next());
            }
            System.out.println(wordBreak(s, list));
        }
    }
}
