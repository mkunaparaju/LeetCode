package Amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.*;

public class SymmetricTree {

    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]
//1,2,2,null,3,null,
        TreeNode node1 = new TreeNode(1);
        TreeNode node2l = new TreeNode(2);
        TreeNode node2r = new TreeNode(2);
        TreeNode node3l = new TreeNode(3);
        TreeNode node3r = new TreeNode(3);
        TreeNode node4l = new TreeNode(4);
        TreeNode node4r = new TreeNode(4);

        node1.left = node2l;
        node1.right = node2r;
        node2l.left = node3l;
        node2l.right = node4l;

        node2r.left = node4r;
        node2r.right = node3r;

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2l = new TreeNode(2);
//        TreeNode node2r = new TreeNode(2);
//        TreeNode node3l = new TreeNode(3);
//        TreeNode node3r = new TreeNode(3);
//
//        node1.left = node2l;
//        node1.right = node2r;
//        node2l.left = node3l;
//
//
//        node2r.left = node3r;

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(node1));

    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public boolean isSymmetricIter(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) return false;
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!stack.empty()) {
            if (stack.size() % 2 != 0) return false;
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) return false;

            if (left.left != null) {
                if (right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
