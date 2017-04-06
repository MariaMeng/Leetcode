import java.util.*;
/**
 * Created by apple on 17/3/29.
 * Google 17/3/27 真题
 */
public class MorseCode {
    class TrieNode {
        String letter; // plaintext
        Map<Character, TrieNode> children;
        public TrieNode(String str) {
            children = new HashMap<>();
            letter = str;
        }
        public TrieNode() {
            children = new HashMap<>();
        }

    }

    TrieNode root;
    public MorseCode() {
        root = new TrieNode("");
    }
    /*
        假设morseMap，Key为morseCode, value为 String, 单词
     */
    public int toMessage(String word, Map<String, String> morseMap) {
        // 1. construct the Trie Morse code
        for (Map.Entry<String, String> entry : morseMap.entrySet()) {
            insert(entry);
        }
        // 2. 怎样查找给的字符串？回溯+ Trie树
        return 0;
    }
    private void insert(Map.Entry<String, String> entry) {
        TrieNode node = root;
        for (int i = 0; i < entry.getKey().length(); i++) {
            char c = entry.getKey().charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.letter = entry.getValue();
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

    }

}
