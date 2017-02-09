package Experience;

/**
 * Created by apple on 17/1/30.
 */
class Node{
    protected Node next;
    protected int data;
    //constructor
    public Node(int data) {
        this.data = data;
    }
    public void display(){
        System.out.print(data + " ");
    }
}
public class LinkList {
    public Node first; //定义一个头结点
    private int pos = 0; //节点位置
    //constructor
    public LinkList() {
        this.first = null;
    }
    //插入一个头节点
    public void addFirstNode(int data) {
        Node node = new Node(data);
        node.next = first;
        first = node;
    }
    //删除一个头节点，并返回头节点
    public Node deleteFirstNode() {
        Node tempNode = first;
        first = tempNode.next;
        return tempNode;
    }
    //在任意位置插入节点， 在index后面插入
    public void add(int index, int data) {
        Node node = new Node(data);
        Node current = first;
        Node previous = first;
        while(pos != index) {
            previous = current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }
    //删除任意位置的节点
    public Node deleteByPos(int index) {
        Node current = first;
        Node previous = first;
        while(pos != index) {
            pos++;
            previous = current;
            current =current.next;
        }
        if(current == first) {
            first = first.next;
        }else {
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }
}
