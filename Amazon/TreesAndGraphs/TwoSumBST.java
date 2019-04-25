package Amazon.TreesAndGraphs;

import java.util.*;

public class TwoSumBST {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashSet<Integer> complSet = new HashSet<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int complement = k - node.val;

            if (!complSet.contains(complement)) complSet.add(complement);
            else return true;

            if(node.left!= null) queue.offer(node.left);
            if(node.right!= null) queue.offer(node.right);
        }

        return false;
    }

}
