package Google.DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int [][] grid = {  {1,3,1}, {1,5,1}, {4,2,1}};
        int [][] grid2 = {{1,2},{5,6},{1,1}};
        MinimumPathSum mps = new MinimumPathSum();;
//        System.out.println(mps.minPathSum(grid));
        System.out.println(mps.minPathBottomUp(grid));
    }

    private int minPathSum(int[][] grid) {
//        return minPathSum(grid, 0, 0);
        int [][] path =  new int [grid.length][grid[0].length];
        for (int[] row: path) {
            Arrays.fill(row, -1);
        }
        return minPathSumMemo(grid, 0 ,0, path);
    }

    private int minPathSum(int[][] grid, int row, int col) {
        if(row == grid.length - 1 && col == grid[row].length - 1) return grid[row][col];

        if(row == grid.length - 1 ) return (grid[row][col] + minPathSum(grid, row, col +1));
        if(col == grid[row].length - 1 ) return (grid[row][col] + minPathSum(grid, row +1 , col));

        int path1 = minPathSum(grid, row+1, col);
        int path2 = minPathSum(grid, row, col+1);

        return grid[row][col] + ((path1 < path2)? path1:path2);

    }

    private int minPathSumMemo(int [][] grid, int row, int col, int[][] path ){
        if(path[row][col] != -1) return path[row][col];

        if(row == grid.length - 1 && col == grid[row].length - 1) return grid[row][col];
        int pathVal = 0;
        if(row == grid.length - 1 ) {
            pathVal = grid[row][col] + minPathSumMemo(grid, row, col +1, path);
            path[row][col] = pathVal;
            return pathVal;
        }
        if(col == grid[row].length - 1 ) {
            pathVal = (grid[row][col] + minPathSumMemo(grid, row +1 , col, path));
            path[row][col] = pathVal;
            return pathVal;
        }

        int path1 = minPathSumMemo(grid, row+1, col, path);
        int path2 = minPathSumMemo(grid, row, col+1, path);
        pathVal = grid[row][col] + ((path1 < path2)? path1:path2);
        path[row][col] = pathVal;
        return pathVal;
    }

    private int minPathBottomUp(int [][] grid){
       for(int i = 0; i < grid.length; i++){
           for(int j = 0; j < grid[i].length; j++){
               if(i == 0) {
                   if(j!=0) grid[i][j] = grid[i][j] + grid[i][j-1];
                   continue;
               }
               if(j == 0) {
                   if(i!=0) grid[i][j] = grid[i][j] + grid[i-1][j];
                   continue;
               }
               int min = (grid[i-1][j] < grid[i][j-1])? grid[i-1][j]:grid[i][j-1];
               grid[i][j] = grid[i][j] + min;
           }
       }
       return grid[grid.length - 1][grid[0].length - 1];
    }
}
