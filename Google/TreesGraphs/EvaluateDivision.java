package Google.TreesGraphs;

import sun.security.krb5.internal.PAData;

import java.util.ArrayDeque;
import java.util.HashMap;

public class EvaluateDivision {

    public static void main(String[] args) {
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Node> nodeMap = new HashMap<>();
        double [] answers = new double[queries.length];

        for(int i = 0; i < equations.length ; i++){
            String [] equation = equations[i];
            String parent = equation[0];
            String child = equation[1];

            Node parentNode = null;
            Node childNode = null;

            if(!nodeMap.containsKey(parent)) {
                parentNode = new Node(parent);
                nodeMap.put(parent, parentNode);
            } else {
                parentNode = nodeMap.get(parent);
            }

            if(!nodeMap.containsKey(child)){
                childNode = new Node(child);
                nodeMap.put(child, childNode);
            } else {
                childNode = nodeMap.get(child);
            }

            parentNode.addChild(childNode, values[i]);
            childNode.addParent(parentNode, 1/values[i]);
        }

        for(int i = 0; i < queries.length; i++){
            int pathValue = getPathVal(queries[i][0],queries[i][1], nodeMap);
        }

        return answers;
    }

    private int getPathVal(String pQuery, String cQuery, HashMap<String, Node> nodeMap) {
        ArrayDeque childStack = new ArrayDeque();

        
    }
}


class Node{
    private String label;
    private HashMap<String, Double> childMap;
    private HashMap<String, Double> parentMap;

    Node(String lable){
        this.label = lable;
        childMap =new HashMap<>();
        parentMap = new HashMap<>();
    }

    void addChild(Node child, double weight){
       if( !childMap.containsKey(child.label)) {
            childMap.put(child.label, weight);
        }
    }

    void addParent(Node parent, double weight){
        if(!parentMap.containsKey(parent.label)){
            parentMap.put(parent.label, weight);
        }
    }

}