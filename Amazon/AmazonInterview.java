package Amazon;

import java.util.*;

public class AmazonInterview {
    public static void main(String[] args) {
        AmazonInterview a = new AmazonInterview();

        int numDest = 3;
        List<List<Integer>> allLoc = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);


        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);


        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(-1);


        allLoc.add(a1);
        allLoc.add(a2);
        allLoc.add(a3);

        int numDelivery = 2;

        List<List<Integer>> delLoc = a.ClosestXdestinations(numDest, allLoc, numDelivery);

        for(List<Integer> loc : delLoc){
            for(int cord : loc){
                System.out.print(cord+ " ");
            }
            System.out.println();
        }

    }


    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {

        PriorityQueue<List<Integer>> destQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int y1 = o1.get(1);

                int x2 = o2.get(0);
                int y2 = o2.get(1);

                double dest1 = Math.sqrt((x1*x1) + (y1*y1));
                double dest2 = Math.sqrt((x2*x2) + (y2*y2));


                return (dest1 < dest2)? -1 : 1 ;
            }
        });

       for(List<Integer> location : allLocations){
           destQueue.add(location);
       }

       List<List<Integer>> deliverydest = new ArrayList<List<Integer>>();

       int count = 0;
       while(count < numDeliveries){
           deliverydest.add(destQueue.poll());
           count++;
       }
       return deliverydest;
     }
}
