package Microsoft.TreesAndGraphs;

import Google.ArraysStrings.TrapWater;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Inorder {
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root.left != null) list.addAll(inorderTraversalRec(root.left));
        list.add(root.val);
        if (root.right != null) list.addAll(inorderTraversalRec(root.right));
        return list;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        if(root == null ) return Collections.emptyList();
        List<Integer> out = new ArrayList<>();

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left!= null ) {
                stack.push(node.left);
                node.left = null;
                continue;
            }
            out.add(node.val);
            stack.pop();
            if(node.right!= null) stack.push(node.right);
        }


        return out;
    }
}
