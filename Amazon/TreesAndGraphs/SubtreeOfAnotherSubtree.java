package Amazon.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubtreeOfAnotherSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode temp = s;
        boolean isSub = false;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(temp);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == t.val) {
                if(checkEquality(node, t)) isSub = true;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return  isSub;
    }

    private boolean checkEquality(TreeNode node, TreeNode t) {
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<TreeNode> tQueue = new ArrayDeque<>();

        nodeQueue.offer(node);
        tQueue.offer(t);

        while(!nodeQueue.isEmpty() && !tQueue.isEmpty()){
            TreeNode n1 = nodeQueue.poll();
            TreeNode n2 = tQueue.poll();


            if(n1.val!= n2.val) return false;

            if (n1.left != null) nodeQueue.offer(n1.left);
            if (n1.right != null) nodeQueue.offer(n1.right);

            if (n2.left != null) tQueue.offer(n2.left);
            if (n2.right != null) tQueue.offer(n2.right);


        }
        System.out.println(nodeQueue.size() + " "+ tQueue.size());
        return nodeQueue.size() == tQueue.size();
    }
}
