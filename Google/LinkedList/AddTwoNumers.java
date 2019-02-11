package Google.LinkedList;

public class AddTwoNumers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int length1 = getSize(l1);
        int length2 = getSize(l2);

        if(length1 < length2) l1 = padZero(l1, (length2 - length1));
        else if(length2 < length1) l2 = padZero(l2, (length1 - length2));

    return null;

    }

    private ListNode padZero(ListNode l2, int diff) {

        return l2;
    }

    private int getSize(ListNode l1) {

        return 0;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

