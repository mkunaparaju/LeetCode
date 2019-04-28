package Amazon.TreesAndGraphs;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree gvt = new GraphValidTree();
        int[][] arr1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] arr2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(gvt.validTree(5, arr1));
    }

    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        int start = edges[0][0];

        for (int[] edge : edges) {
            if (edgeMap.containsKey(edge[0])) {
                List<Integer> ends = edgeMap.get(edge[0]);
                ends.add(edge[1]);
            } else {
                List<Integer> ends = new ArrayList<>();
                ends.add(edge[1]);
                edgeMap.put(edge[0], ends);
            }
        }

return false;
    }
}
