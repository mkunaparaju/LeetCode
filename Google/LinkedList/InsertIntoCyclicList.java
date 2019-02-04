package Google.LinkedList;


class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
}

public class InsertIntoCyclicList {

    public Node insert(Node head, int insertVal) {
        if(head == null) return new Node(insertVal, null);
        Node node = head;
        Node prev =node;
        Node max = head;
        while(node.next != null){
            if (node.val >= max.val) {
                max = node;
            }

            prev = node;
            node = node.next;

            if(prev.val < insertVal && insertVal < node.val){
                Node newNode = new Node(insertVal, node);
                prev.next = newNode;
                return head;
            }
        }

        Node newNode = new Node(insertVal, max.next);
        max.next = newNode;
        return head;
    }
}
