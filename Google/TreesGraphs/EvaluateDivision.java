package Google.TreesGraphs;

import java.util.HashMap;

public class EvaluateDivision {

    public static void main(String[] args) {

    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Node> nodeMap= new HashMap<>();

        for(int i = 0; i< equations.length; i++){
            String [] equation = equations[i];

            Node toChildNode = new Node(equation[1],values[i]);
            Node toParentNode  = new Node(equation[0], (1/values[i]));

            nodeMap.put(equation[0], toChildNode);
            nodeMap.put(equation[1], toParentNode);
        }

return null;
    }
}

class Node{
    private String label;
    private double value;

    Node(String label, double value){
        this.label = label;
        this.value = value;
    }

}