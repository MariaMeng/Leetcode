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
    boolean isLeaf;
    public TrieNode() {
        children = new LinkedHashMap<>();
        isLeaf = false;
    }
}
public class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0 ; i < n; i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isLeaf = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0 ; i < n ; i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.isLeaf;
    }
    public boolean startsWith(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0 ; i < n ; i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return true;
    }
    public static  void main(String[] args) {
        Trie my  = new Trie();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next(); // str
            int n = in.nextInt(); // num of words in dic
            while (n-- != 0) {
                my.insert(in.next());
            }
            System.out.println("Search: " + my.search(s));
            System.out.println("StartWith: " + my.startsWith(s));
        }
    }
}
