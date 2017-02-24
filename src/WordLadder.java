import java.util.*;
/**
 * Created by apple on 17/2/15.
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 解题思路：
 1. 采用BFS方法
 2. start集合， end集合分别保存头和尾
 3. 搜索字符串
 4. temp集合不断更新当前的新邻居
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordAList) {
        if (!wordAList.contains(endWord)) return 0;

        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        Set<String> wordList = new HashSet<String>(wordAList); // 去重，并且加速，必不可少

        int len = 1;

        start.add(beginWord);
        end.add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);

        while (!start.isEmpty() && !end.isEmpty()) {
            if (start.size() > end.size()) {
                //swap two sets
                Set<String> set = start;
                start = end;
                end = set;
            }

            Set<String> temp = new HashSet<String>(); // store new neighbours
            for (String word : start) {
                char[] chs = word.toCharArray(); // convert into array

                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chs[i] == c) continue;
                        chs[i] = c;

                        String target = String.valueOf(chs);

                        if (end.contains(target)) { // return result here
                            return len + 1;
                        }

                        if (wordList.contains(target)) {
                            temp.add(target);
                            wordList.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }

            start = temp;
            len++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder mySolution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordListList = new ArrayList<>();
        Collections.addAll(wordListList, wordList);
        //System.out.println(wordListSet.size());
        int result = mySolution.ladderLength(beginWord, endWord, wordListList);
        System.out.println(result);
    }
}
