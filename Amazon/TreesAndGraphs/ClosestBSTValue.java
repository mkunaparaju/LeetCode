package Amazon.TreesAndGraphs;

import Amazon.ArraysAndStrings.MaxSubArrayEqualsK;

public class ClosestBSTValue {
    //[7,5,9,2,3]
    //2.714286
    double minDifference = Double.MAX_VALUE;
    int minNodeValue = -1;

    public int closestValue(TreeNode root, double target) {
        if (root == null) return minNodeValue;
        System.out.println("minDiff "  + minDifference );
        if (minDifference >= Math.abs(target - Double.valueOf(root.val))) {
            minDifference = Math.abs(target - Double.valueOf(root.val));
            minNodeValue = root.val;
        }

        if (target < root.val) {
            closestValue(root.left, target);
        } else {
            closestValue(root.right, target);
        }

        return minNodeValue;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
//        TreeNode node2l = new TreeNode(5);
//        TreeNode node2r = new TreeNode(9);
//        TreeNode node3l = new TreeNode(2);
//        TreeNode node3r = new TreeNode(6);
//        TreeNode node4l = new TreeNode(4);
//        TreeNode node4r = new TreeNode(4);

//        node1.left = node2l;
//        node1.right = node2r;
//        node2l.left = node3l;
//        node2l.right = node3r;

        ClosestBSTValue cb = new ClosestBSTValue();
        System.out.println(cb.closestValue(node1, 2147483648.0));
    }
}