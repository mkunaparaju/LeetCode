package Amazon.TreesAndGraphs;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Deque;
import java.util.LinkedList;

public class CountIslands {
    public static void main(String[] args) {
        char [][] in = {{'1','1','1','1','0'},{ '1','1','0','1','0'},{'1','1','0','0','0'},{ '0','0','0','0','0'}};
        CountIslands ci = new CountIslands() ;
        System.out.println(ci.numIslands(in));
    }
//    public int numIslands(char[][] grid) {
//        Deque<Pos> queue = new LinkedList<>();
//        int numIslands = 0;
//        for(int i = 0; i < grid.length; i++){
//            for( int j = 0; j < grid[0].length; j++){
//                if(grid[i][j] == '0' || grid[i][j] == '2'  ) {
////                    System.out.println("grid pos " + grid[i][j]);
//                    continue;
//                }
//                else{
//                    queue.offer(new Pos(i, j));
//                    while(!queue.isEmpty()){
//                        Pos presPos = queue.poll();
//                        int presRow = presPos.row;
//                        int prescol = presPos.col;
//                        System.out.println("row "+ presRow +" col " + prescol);
//                        grid[presRow][prescol] = '2';
//                        Pos nextPos1 = new Pos(presRow +1, prescol);
//                        Pos nextPos2 = new Pos(presRow, prescol + 1);
//                        Pos nextPos3 = new Pos(presRow -1, prescol);
//                        Pos nextPos4 = new Pos(presRow, prescol - 1);
//                        if(presRow < grid.length -1 && grid[presRow+1][prescol] == '1') queue.offer(nextPos1);
//                        if(prescol < grid[0].length - 1 && grid[presRow][prescol+1] == '1' ) queue.offer(nextPos2);
//                        if(presRow > 0 && grid[presRow-1][prescol] == '1') queue.offer(nextPos3);
//                        if(prescol >0 && grid[presRow][prescol-1] == '1' ) queue.offer(nextPos4);
//                    }
//
//                }
//                numIslands++;
//            }
//        }
//        return numIslands;
//    }

    private int n;
    private int m;


    public int numIslands(char[][] grid) {
        int count = 0;
         n = grid.length;
        if (n == 0) return 0;
         m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}

class Pos{
    int row;
    int col;

    Pos(int row, int col){
        this.row = row;
        this.col = col;
    }
}