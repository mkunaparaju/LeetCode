package Amazon;

import java.util.*;

public class AmazonInterview1 {
    public static void main(String[] args) {
        AmazonInterview1 a = new AmazonInterview1();
        int numRows = 3;
        int numColumns = 3;

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(0);
        a1.add(0);


        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(0);
        a2.add(0);


        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(9);
        a3.add(1);

        List<List<Integer>>  lot = new ArrayList<>();
        lot.add(a1);
        lot.add(a2);
        lot.add(a3);

        int dist = a.removeObstacle(numRows,numColumns,lot);

        System.out.println(dist);
    }

    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    private static boolean isValid(int mat[][], boolean visited[][],
                                   int row, int col, int rowMax, int colMax)
    {
        return (row >= 0) && (row < rowMax) && (col >= 0) && (col < colMax)
                && mat[row][col] == 1 && !visited[row][col];
    }

    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){
        int [][] grid = convertToGrid(lot, numRows, numColumns);
        boolean [][] visited = new boolean [numRows][numColumns];

        ArrayDeque<Location> locQueue = new ArrayDeque<>();
        locQueue.add(new Location(0,0, 0));
        visited[0][0] = true;

        int minDist = Integer.MAX_VALUE;

        while(!locQueue.isEmpty()){
            Location loc = locQueue.poll();

            int x = loc.x;
            int y = loc.y;
            int dist = loc.distance;

            if(grid[x][y] == 9) {
                minDist = dist;
                break;
            }

            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(grid, visited, x + row[k], y + col[k], numRows, numColumns))
                {
                    // mark next cell as visited and enqueue it
                    visited[x + row[k]][y + col[k]] = true;
                    locQueue.add(new Location(x + row[k], y + col[k], dist + 1));
                }
            }
        }
        return minDist;
    }

    private int[][] convertToGrid(List<List<Integer>> lot, int numRows, int numColumns) {
        int [][] grid = new int [numRows][numColumns];
        for(int i = 0; i < numColumns; i++){
            for (int j = 0; j < numRows; j++){
                grid[i][j] = lot.get(i).get(j);
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        return grid;
    }

}
class Location {
    int x;;
    int y;
    int distance;

    Location(int x,int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    void setDistance(int distance){
        distance++;
    }
    }