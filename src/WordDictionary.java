import java.util.*;
/**
 * Created by apple on 17/3/29.
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class WordDictionary {
    class TrieNode {
        boolean wordEnd;
        Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<>();
            wordEnd = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.wordEnd = true;
    }
    /** Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                    node = entry.getValue();
                }
            }
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.wordEnd;
    }
}
