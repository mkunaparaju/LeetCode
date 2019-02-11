package Google.LinkedList;

import java.util.HashMap;

public class DeepCpy {

    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> oldNewMap = new HashMap<>();

        RandomListNode newHead = head;
        oldNewMap.put(head, newHead);

        RandomListNode node = newHead;
        RandomListNode out = newHead;
        while(head != null){
            newHead.next = head.next;
            oldNewMap.put(head.next, newHead.next);

            head= head.next;
            newHead = newHead.next;
        }

        while(node != null){
            node.random = oldNewMap.get(node.random);
            node = node.next;
        }

        return out;

    }
}


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

