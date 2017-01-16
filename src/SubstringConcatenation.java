import java.util.*;

/**
 * Created by apple on 17/1/6.
 */
public class SubstringConcatenation {
    /*
        方法一： 采用two poiners 和 Hashmap 方法： Simple Java Solution with Two Pointers and Map
        运行效率：170ms左右
        S:字符串
        L:所有单词组成的字符串数组
        Just build a map for the words and their relative count in word list L.
        Then we traverse through S to check whether there is a match.
        Use two poiners:
        i: Traverse all characters in String S
        j: Traverse all characters in word lists L
     */

    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();//返回的子串的首地址，组成的ArrayList
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word,题目中每个单词长度一样

        //初始化HashMap，注意L中可能包含多个相同的字符串，所以用value表示个数
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L

        //方法一：
        //for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        //方法二：
        for (int i=0; i < L.length; i++){
            if(map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            }else
                map.put(L[i], 1);
        }

        /*
            滑动窗口：
            i:遍历原始字符串S中的每个字符，截止到S.length()-len*L.length
            j:遍历字典L中的每个单词
            右窗口滑动：内层FOR循环，如果当前子串在字典中，则右窗口右移一个单词，知道字典中为空
            左窗口滑动：外层FOR循环，如果当前子串不在字典中，则左窗口左移一个字符
         */
        //循环截止条件 S.length()-len*L.length 表示最后一个可能的完整子字符串的初始下标
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);//复制一个新的Map，满足条件的子串可能有多个
            for (int j = 0; j < L.length; j++) { // 遍历字典中的每个单词
                String str = S.substring(i + j*len, i + j*len + len); //Substring(start,stop) start:首地址，stop:最后地址不包括
                if (copy.containsKey(str)) { // 如果该子串在字典中有
                    int count = copy.get(str);//返回字典中子串对应单词出现的次数
                    if (count == 1) copy.remove(str);//如果单词出现了一次，则直接删除
                    else copy.put(str, count - 1);//如果单词出现多于一次的情况，则出现的次数-1，使用put函数对原有<key,value>进行修改
                    if (copy.isEmpty()) {//如果字典为空,代表找到了满足条件的子串
                        res.add(i);

                        System.out.println(i);

                        break;//这个break要不要都行,超时时好时坏
                    }//如果字典不为空，则继续 '字典遍历'
                } else break; //如果该子串不在字典中，则跳出'字典遍历'循环
            }//End 遍历字典L
        }//End 遍历原始字符串S
        return res;
    }

    /*
        方法二："没看懂"算法：Accepted Java solution 12ms with explanation
        运行效率：25ms
        s: 字符串
        words: 单词字典

     */
    public List<Integer> findSubstring_Another(String s, String[] words) {
        int N = s.length();//字符串长度
        List<Integer> indexes = new ArrayList<Integer>(s.length());//创建一个初始长度为s.length()的ArrayList
        if (words.length == 0) {
            return indexes;
        }
        int M = words[0].length();//M 为单词长度
        if (N < M * words.length) { //如果元字符串S长度 小于 所有单词长度的综合，则直接返回
            return indexes;
        }
        int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        int [][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) { //遍历每个单词
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) { //遍历S中的所有字符，窗口长度为M，每次向右滑动一格，如果该子串在字典中存在，则返回在字典中的位置
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }


    public static void main(String[] args) {
        SubstringConcatenation mySolution = new SubstringConcatenation();
        //String S = "foobarfoofoobarfooman";
        //System.out.println(S);
        //System.out.println("The substring of S from index 3 to index 5 is:" + S.substring(3,6));
        //String[] words = {"foo", "bar", "foo"};

        String S="abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};

        System.out.println("S字符串长度为：" + S.length());
        System.out.println("word字典长度为：" + words.length);
        Map<String,Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        for (Map.Entry<String ,Integer> entry : map.entrySet()) {
            System.out.println("单词 " + entry.getKey() + ": " + entry.getValue());
        }

        List<Integer> myList = mySolution.findSubstring_Another(S, words);
        System.out.println("Size is: " + myList.size());
        for (int i : myList) {
            System.out.println(i);
        }

        /*
        Map<String,Integer> mymap = new HashMap<>();
        mymap.put("aa",1);
        mymap.put("aa",2);
        mymap.put("b",3);

        for (Map.Entry<String, Integer> myentry : mymap.entrySet()) {
            System.out.println(myentry.getKey() + "\t" + myentry.getValue());
        }
        */
    }
}
