package Google.TreesGraphs;

public class UnivaluePath {

    public static void main(String[] args) {

    }

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestUnivaluePath1(root);
        return ans;
    }

    public int longestUnivaluePath1(TreeNode root) {
        if (root == null) return 0;
        int leftPath = longestUnivaluePath1(root.left);
        int rightPath = longestUnivaluePath1(root.right);

        System.out.println(leftPath + " " + rightPath);
        int lWithRoot = 0;
        int rWithRoot = 0;
        // int combined = 0;
        if (root.left != null && root.left.val == root.val) lWithRoot += leftPath + 1;
        if (root.right != null && root.right.val == root.val) rWithRoot += rightPath + 1;
        ans = Math.max(ans, lWithRoot + rWithRoot);
        return Math.max(lWithRoot, rWithRoot);
    }
}
