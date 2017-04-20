import java.util.*;
/**
 * Created by apple on 17/4/19.
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 when there is a tie (i.e., two or more keys that have the same frequency),
 the least recently used key would be evicted.
 */
public class LFUCache {
    class Node {
        public int count = 0;
        public LinkedHashSet<Integer> keys = null;
        public Node prev = null, next = null; // double link list

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>(); // create an set
            prev = next = null;
        }
    }

    private Node head = null;
    private int cap = 0;
    private HashMap<Integer, Integer> valueHash = null;
    private HashMap<Integer, Node> nodeHash = null;

    public LFUCache(int capacity) {
        this.cap = capacity;
        valueHash = new HashMap<Integer, Integer>();
        nodeHash = new HashMap<Integer, Node>();
    }

    /*
        获取当前cache中的key对应的值
     */
    public int get(int key) {
        if (valueHash.containsKey(key)) { // 如果之前存在key
            increaseCount(key);
            return valueHash.get(key);
        } // 如果之前没有该key
        return -1;
    }

    public void set(int key, int value) {
        if ( cap == 0 ) return;
        // 如果map中包含该key
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        }
        // 如果map中不包含该key
        else {
            // 如果容量未满
            if (valueHash.size() < cap) {
                valueHash.put(key, value);
            }
            // 如果容量已满
            else {
                removeOld();
                valueHash.put(key, value);
            }
            addToHead(key);
        }
        increaseCount(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }

    private void increaseCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);
        // 如果node下一个没有，则创建一个Node节点，并连接好
        if (node.next == null) {
            node.next = new Node(node.count+1);
            node.next.prev = node;
            node.next.keys.add(key);
        } // 如果node节点的下一个节点为 count + 1的节点
        else if (node.next.count == node.count+1) {
            node.next.keys.add(key);
        }
        // 如果node下一个节点的count值 != count + 1,则插入一个新的Node节点
        // 并建立好双向连接
        else {
            Node tmp = new Node(node.count+1);
            tmp.keys.add(key);
            tmp.prev = node;
            tmp.next = node.next;
            node.next.prev = tmp;
            node.next = tmp;
        }

        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) remove(node);
    }

    private void removeOld() {
        if (head == null) return;
        int old = 0;
        for (int n: head.keys) {
            old = n;
            break;
        }
        head.keys.remove(old);
        if (head.keys.size() == 0) remove(head);
        nodeHash.remove(old);
        valueHash.remove(old);
    }

    private void remove(Node node) {
        // 如果当前节点的prev为空
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }


}
