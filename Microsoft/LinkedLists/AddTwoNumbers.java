package Microsoft.LinkedLists;
//https://leetcode.com/explore/interview/card/microsoft/32/linked-list/170/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        AddTwoNumbers r = new AddTwoNumbers();
        ListNode returned = r.addTwoNumbers(node1,node2);

        while(returned != null){
            System.out.println(returned.val);
            returned =returned.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int carry = 0;
        while(l1 != null || l2 !=null){
            int val = 0;
            if(l1 == null ) {
                val = l2.val;
                l2=l2.next;
            }
            else if(l2 == null) {
                val= l1.val;
                l1 = l1.next;
            }
            else{
                val = l1.val+l2.val;
                l1 = l1.next;
                l2=l2.next;
            }
            val = val + node.val;
            if(val > 9) {
                carry = 1;
                val = val - 10;
            }

            node.val = val;

            if(l1 !=null || l2 != null || carry != 0){
                node.next = new ListNode(carry);
                node= node.next;
                carry = 0;
            }
        }
        return head;
    }

}
