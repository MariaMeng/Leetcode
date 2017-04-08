import Experience.LinkList;

import java.util.*;

/**
 * Created by apple on 17/4/8.
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 Please reload the code definition to get the latest changes.
 题意：
 已知一个字符串，一个字典，word。
 求给定一个字符串，有几种划分成不同单词的分类方法。
 */
public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new LinkedHashMap<String, LinkedList<String>>());
    }
    private static List<String> helper(String s, List<String> wordDict, LinkedHashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sub = helper(s.substring(word.length()), wordDict, map);
                for (String str : sub) {
                    res.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next(); // 输入一个字符串
            int n = in.nextInt(); // num of words in the dic
            List<String> list = new ArrayList<>();
            while ( n-- != 0) {
                list.add(in.next());
            }
            List<String> res = wordBreak(s, list);
            for (String str : res) {
                System.out.println(str);
            }
        }
    }
}
