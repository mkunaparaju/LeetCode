package Microsoft.TreesAndGraphs;

import javafx.beans.binding.IntegerExpression;

public class ValidateBST {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root == null) return  true;
        if(root.val <= minValue || root.val >= maxValue) return false;

        System.out.println(" root " + root.val +  " min  " + minValue + " max " + maxValue);
        boolean left = (root.left!= null)? isValidBST(root.left, minValue, root.val) : true;;
        boolean right = (root.right!= null)? isValidBST(root.right, root.val, maxValue) : true;;

        return  left&& right;
    }


}
