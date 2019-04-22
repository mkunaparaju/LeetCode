package Amazon.TreesAndGraphs;

public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2l = new TreeNode(9);
        TreeNode node2r = new TreeNode(0);
        TreeNode node3l = new TreeNode(5);
        TreeNode node3r = new TreeNode(1);
//        TreeNode node4l = new TreeNode(4);
//        TreeNode node4r = new TreeNode(4);

        node1.left = node2l;
        node1.right = node2r;
        node2l.left = node3l;
        node2l.right = node3r;

        SumRootToLeaf stl = new SumRootToLeaf();
        System.out.println(stl.sumNumbers(node1));

    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "", 0);
    }

    private int sumNumbers(TreeNode root, String num, int sum) {
        if(root == null) return 0;
        System.out.println("root  " + root.val);
        num = num + root.val;
        System.out.println("num " + num);
        if(root.left == null && root.right == null) {

            sum = sum + Integer.parseInt(num);
        }

        return sum + sumNumbers(root.left, num, sum) + sumNumbers(root.right, num, sum);
    }
}
