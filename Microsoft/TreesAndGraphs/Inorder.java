package Microsoft.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


public class Inorder{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root.left!= null) list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        if(root.right!= null) list.addAll(inorderTraversal(root.right));
        return list;
    }



}
