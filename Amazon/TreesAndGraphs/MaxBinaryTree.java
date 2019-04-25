package Amazon.TreesAndGraphs;

import java.util.*;

public class MaxBinaryTree {
    public static void main(String[] args) {
//
//        TreeNode node1 = new TreeNode(0);
//        TreeNode node2l = new TreeNode(3);
//        TreeNode node2r = new TreeNode(5);
////        TreeNode node3l = new TreeNode(2);
//        TreeNode node3r = new TreeNode(2);
////        TreeNode node4l = new TreeNode(4);
//        TreeNode node4r = new TreeNode(1);
//
//        node1.left = node2l;
//        node1.right = node2r;
////        node2l.left = node3l;
//        node2l.right = node3r;
//        node3r.right = node4r;
//

        int[] nums = {3, 2, 1, 6, 0, 5};

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }

        return stack.isEmpty() ? null : stack.removeLast();
    }
}
