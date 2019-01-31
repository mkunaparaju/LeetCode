package Google.ArraysStrings;

public class GameOfLife {

    public static void main(String[] args) {

        int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife gol = new GameOfLife();
        gol.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {

        int [][] auxBoard = new int [board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int liveNeighbourCount = 0;

                for(int iSmall  = i-1; iSmall <= i+1; iSmall++){
                    for(int jSmall  = j-1; jSmall <= j+1; jSmall++){

                        if(iSmall == -1 || jSmall == -1 || iSmall >= board.length || jSmall >= board[0].length ) continue;
                        if(iSmall == i && jSmall == j) continue;

                        liveNeighbourCount += board[iSmall][jSmall];


                        System.out.println("iSmall "+ iSmall + " jSmall " + jSmall + " i "+ i+  " j "+ j+ " live " + liveNeighbourCount );
                    }
                }

                if(liveNeighbourCount == 3 && (board[i][j] == 0)) auxBoard[i][j] = 1;
                else if(liveNeighbourCount < 2 || liveNeighbourCount > 3) auxBoard[i][j] = 0;
                else if (liveNeighbourCount >=2 && liveNeighbourCount <=3 ) auxBoard [i][j] = 1;


            }
        }
        board = auxBoard;


//        for(int i =0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println("");
        }
    }
