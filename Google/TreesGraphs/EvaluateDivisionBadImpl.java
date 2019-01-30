package Google.TreesGraphs;

import java.util.ArrayDeque;
import java.util.HashMap;

public class EvaluateDivisionBadImpl {

    public static void main(String[] args) {
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, TestNode> nodeMap = new HashMap<>();
        double[] answers = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            String parent = equation[0];
            String child = equation[1];

            TestNode parentNode = null;
            TestNode childNode = null;

            if (!nodeMap.containsKey(parent)) {
                parentNode = new TestNode(parent);
                nodeMap.put(parent, parentNode);
            } else {
                parentNode = nodeMap.get(parent);
            }

            if (!nodeMap.containsKey(child)) {
                childNode = new TestNode(child);
                nodeMap.put(child, childNode);
            } else {
                childNode = nodeMap.get(child);
            }

            parentNode.addChild(childNode, values[i]);
            childNode.addParent(parentNode, 1 / values[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            double pathValue = getPathVal(queries[i][0], queries[i][1], nodeMap);
        }

        return answers;
    }

    private double getPathVal(String pQuery, String cQuery, HashMap<String, TestNode> nodeMap) {
        if (!nodeMap.containsKey(pQuery) || !nodeMap.containsKey(cQuery)) return -1;
        if (pQuery == cQuery) return 1;

        HashMap<String, Double> pathValueMap = new HashMap<>();

        ArrayDeque<String> childQueue = new ArrayDeque();
        TestNode parentNode = nodeMap.get(pQuery);
        //adding all children of the parent query to stack
        //adding values from parent to this child in map

        for(String s: parentNode.getChildMap().keySet()){
            childQueue.offer(s);
            pathValueMap.put(s, parentNode.getChildMap().get(s));
        }


        while(!childQueue.isEmpty()){
            String child = childQueue.pop();

            if(pQuery == child){
                return  pathValueMap.get(child);
            }


            childQueue.addAll(nodeMap.get(child).getChildMap().keySet());
        }
return 0;

    }
}


class TestNode {
    private String label;
    private HashMap<String, Double> childMap;
    String parent;
    double parentWeight;

    TestNode(String lable) {
        this.label = lable;
        childMap = new HashMap<>();
        parent = null;
        parentWeight = -1;
    }

    void addChild(TestNode child, double weight) {
        if (!childMap.containsKey(child.label)) {
            childMap.put(child.label, weight);
        }
    }

    void addParent(TestNode parent, double weight) {
        this.parent = parent.label;
        this.parentWeight = weight;
    }

    HashMap<String, Double> getChildMap(){
        return childMap;
    }

    String getParent(){
        return parent;
    }

    double getParentWeight(){
        return parentWeight;
    }


}