package Microsoft.LinkedLists;
//https://leetcode.com/explore/interview/card/microsoft/32/linked-list/169/

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ReverseLinkedList r = new ReverseLinkedList();
        ListNode returned = r.reverseList(node);

        while(returned.next!= null){
            System.out.println(returned.val);
            returned =returned.next;
        }


    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
