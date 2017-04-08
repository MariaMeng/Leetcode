
import java.util.*;

/**
 * Created by lenovo on 2017/4/7.
 * Google 面试题,
 * 已知一段无空格的Morse code,  morse code map
 * return the number of translation in English word
 *解题思路：
 * 0)  翻转map,使得key = morse code, value = character
 * 1） 根据map 构建一颗Trie树
 * 2） 使用DFS + Dp 不断递归，返回各种结果
 */
public class MorseCode {
    class TrieNode {
        Map<Character, TrieNode> children;
        String letter;
        public TrieNode() {
            children = new LinkedHashMap<>();
        }
    }
    TrieNode root;
    public MorseCode() {
        root = new TrieNode();
    }


    /*
        将key = character
        value = morse code
        转换成
        key = morse
        value = character
     */
    public Map<String, String > reverse(Map<String ,String> map) {
        Map<String, String> res = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            res.put(entry.getValue(), entry.getKey());
        }
        return res;
    }

    /*
        key = morse
        value = character
        构建一颗 Trie 树
     */
    public void insert(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            insert(entry.getKey(), entry.getValue());
        }
    }

    private void insert(String code, String letter) {
        TrieNode node = root;
        for (char c : code.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.letter = letter; // store the letter in the Trie
    }
    public List<String> getMessage(String s, Map<String ,String> map) {
        Map<String, String> code = reverse(map);
        insert(code);
        TrieNode node = root;
        //List<String> result = helper(s, node, new LinkedHashMap<String, LinkedList<String>>());
        List<String> result = helper(s, code, new LinkedHashMap<String, LinkedList<String>>());
        return result;
    }
    /*
        方法一： 没有使用Trie树，使用map
     */
    private List<String> helper(String s, Map<String, String> code, LinkedHashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String str : code.keySet()) {
            if (s.startsWith(str)) {
                List<String> sub = helper(s.substring(str.length()), code, map);
                for (String temp : sub) {
                    res.add(code.get(str) + temp);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    /*
        方法二： 使用Trie树
     */
    private List<String> helper(String s, TrieNode node, LinkedHashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        int n = s.length();
        // 比较code 的每个字符
        for (char c : s.toCharArray()) {
            if (node.children.containsKey(c)) {
                List<String> sub = helper(s.substring(1), node.children.get(c), map);
                for (String str : sub) {
                    res.add(node.letter + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main(String[] args) {
        MorseCode my = new MorseCode();
        Scanner in = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(in.next(), in.next());
        }
        String s = in.next(); // get the morse code
        in.close();
        List<String> list = my.getMessage(s, map);
        System.out.println(list);
    }
}
