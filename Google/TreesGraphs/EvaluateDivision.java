package Google.TreesGraphs;

import Google.PrintingHelper;

import java.util.*;


public class EvaluateDivision {

    public static void main(String[] args) {


    }

    //implements solution with examples

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, DivNode> nodeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double val = values[i];

            String start = equation.get(0);
            String end = equation.get(1);
            DivNode startNode = null;
            DivNode endNode = null;

            if(nodeMap.containsKey(start)){
                startNode = nodeMap.get(start);
            }else{
                startNode = new DivNode(start);
            }

            HashMap<String, Double> neighborStart = startNode.neighbours;
            if(!neighborStart.containsKey(end)) {
                neighborStart.put(end, val);
            }

            if(nodeMap.containsKey(end)){
                endNode = nodeMap.get(end);
            }else{
                endNode = new DivNode(end);
            }

            HashMap<String, Double> neighborEnd = endNode.neighbours;
            if(!neighborEnd.containsKey(start)) {
                neighborEnd.put(start, 1.0/val);
            }

        }
        double [] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){

            ans[i] = calculateDivision(queries.get(i).get(0), queries.get(i).get(1), nodeMap);

        }

        return null;
    }

    private double calculateDivision(String start, String end, HashMap<String, DivNode> nodeMap) {
        if(!nodeMap.containsKey(start) || !nodeMap.containsKey(end)) return  -1;

        HashSet<String> visited = new HashSet<>();
        ArrayDeque<CalcNode> queue = new ArrayDeque<>();
        queue.offer(new CalcNode(start, 1.0));
        visited.add(start);


        while(!queue.isEmpty()){
            CalcNode st = queue.poll();
            visited.add(st.name);
            DivNode stNode = nodeMap.get(st.name);
            HashMap<String, Double> neighbors = stNode.neighbours;

            if(neighbors.containsKey(end)) return st.val*neighbors.get(end);
            else{
                Iterator<String> iter = neighbors.keySet().iterator();
                while(iter.hasNext()){
                    String name = iter.next();
                    queue.offer(new CalcNode(name, neighbors.get(name) * st.val ));
                }
            }
        }

        return -1;
    }

}

class DivNode {
    String name;
    HashMap<String, Double> neighbours;

    DivNode(String name) {
        this.name = name;
        neighbours = new HashMap<>();
    }
}

class CalcNode{
    String name;
    Double val;

    CalcNode(String name, Double val){
        this.name = name;
        this.val = val;
    }
}