package Google.TreesGraphs;

import Microsoft.TreesAndGraphs.Inorder;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output= new ArrayList<>();
        HashMap<TreeNode, Integer> nodeColMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();

        // we start at node root with 0 index
        int min =0;
        int max = 0;

        nodeQueue.offer(root);
        nodeColMap.put(root, 0);

        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int index = nodeColMap.get(node);

            if(node.left!= null) {
                nodeQueue.offer(node.left);
                nodeColMap.put(node, index -1);
                min = Math.min(min, index -1);
            }

            if(node.right!= null){
                nodeQueue.offer(node.right);
                nodeColMap.put(node.right, index +1);
                max = Math.max(max, index +1);
            }
        }
        for(int i = 0; i < min+max; i++){
            output.add(new ArrayList<>());
        }

        Queue<TreeNode> finalQueue = new LinkedList<>();
        finalQueue.offer(root);

        while(!finalQueue.isEmpty()){
            TreeNode node = finalQueue.poll();
            int colIndex = nodeColMap.get(node) + min;
            output.get(colIndex).add(node.val);

            if(node.left != null) finalQueue.offer(node.left);
            if(node.right != null) finalQueue.offer(node.right);
        }

        return output;
    }
}
