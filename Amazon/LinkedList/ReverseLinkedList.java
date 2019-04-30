package Amazon.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        return curr;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}