import java.util.*;

/**
 * Created by apple on 17/3/28.
 * 注意事项：
 * 判断startwith方法，与search方法的区别在于，
 * startwith是判断word是否是前缀
 * search判断word是否在Trie树种存在，即时word作为前缀存在于Trie中，但是word如果不是独立的单词，也返回false
 */
class TrieNode {
    Map<Character, TrieNode> children;
    boolean wordEnd;
    public TrieNode() {
        children = new HashMap<>();
        wordEnd = false;
    }
}
public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // insert the String into Trie
    public void insert(String word) {
        // from top to down
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // if root does not contain character
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.wordEnd = true;
    }
    // search if the word is contained in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.wordEnd;
    }
    // search weather the prefix is contained in the trie
    public boolean startsWith(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }
}
