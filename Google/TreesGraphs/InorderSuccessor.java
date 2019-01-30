package Google.TreesGraphs;

import sun.reflect.generics.tree.Tree;

public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode t1= new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);

        root.right = t7;
        root.left = t3;
        t3.right = t5;
        t5.left = t4;
        t3.left = t2;
        t2.left = t1;

        InorderSuccessor is = new InorderSuccessor();
        TreeNode out = is.inorderSuccessor(root,  t5  );
        System.out.println(out.val);


    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p == null) return null;

        if (p.right != null) {
            TreeNode rightRoot = p.right;
            while(rightRoot.left!= null) rightRoot = rightRoot.left;
            return rightRoot;
            }
        else {
            TreeNode successor = null;
            TreeNode leftRoot = root;

            while(leftRoot.val != p.val){
                if(p.val < leftRoot.val){
                    successor = leftRoot;
                    leftRoot = leftRoot.left;
                }else{
                    leftRoot = leftRoot.right;
                }
            }
            return successor;
        }
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
