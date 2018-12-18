package Microsoft.LinkedLists;
//https://leetcode.com/explore/interview/card/microsoft/32/linked-list/175/
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(5);

        MergeTwoSortedLists r = new MergeTwoSortedLists();
        ListNode returned = r.mergeTwoLists(node1,node2);

        while(returned != null){
            System.out.println(returned.val);
            returned =returned.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = null;
        ListNode head = null;

        while(l1 !=null || l2!= null){
            int val = 0;
            if(l1 == null) {
                val = l2.val;
                l2 = l2.next;
            }else if(l2 == null) {
                val = l1.val;
                l1=l1.next;
            }else{
                if((l1.val < l2.val)){
                    val =l1.val;
                    l1 = l1.next;
                }
            else{
                    val = l2.val;
                    l2= l2.next;
                }
            }
            if(merged == null){
                merged = new ListNode(val);
                head = merged;
            }   else{
                ListNode newNode = new ListNode(val);
                merged.next = newNode;
                merged = merged.next;
            }

        }
        return head;
    }
}
