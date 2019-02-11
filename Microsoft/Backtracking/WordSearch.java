package Microsoft.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class WordSearch {

    public static void main(String[] args) {
        char [][] board  ={ {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word= "ABCCED";
        String word1 = "SEE";
        String word2 = "SABCCE" ;
        String word3= "ABCB";



        WordSearch ws= new WordSearch();
        System.out.println(ws.exist(board, word2));

    }

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                        boolean exist = makeWord(board, word, new Coord(i, j), 0, new HashSet<>(), "");
                        if(exist) return exist;
                }
            }
        }
        return false;
    }

    private boolean makeWord(char[][] board, String word, Coord coord, int index, HashSet<Coord> visited, String madeWord) {

        madeWord= madeWord+ word.charAt(index);
        System.out.println("word " + word + " madeWord " + madeWord + " index " + index + " coord "  + coord.row + " " + coord.col);
        if(madeWord.equalsIgnoreCase(word)) return true;
        if(index == word.length()-1) return false;
       // madeWord= madeWord+ word.charAt(index);
        List<Coord> poss = getPossibleCoordinates(board, word.charAt(index+1), coord, visited);

        for(Coord next : poss){
            System.out.println("row " + next.row + " col " + next.col);
            visited.add(next);
            boolean nextWord = makeWord(board, word, next, index+1, visited, madeWord);
            if(nextWord) return true;
        }
        return false;
    }

    private List<Coord> getPossibleCoordinates(char[][] board, char letter, Coord presentCoord, HashSet<Coord> visited) {
        List<Coord> poss= new ArrayList<>();
        System.out.println("letter " + letter +  " coord "  + presentCoord.row + " " + presentCoord.col);
        if(presentCoord.row != 0 ) {
            int row = presentCoord.row - 1,  col = presentCoord.col;
            Coord c1 = new Coord(row, col);
            if(!visited.contains(c1) && board[row][col] == letter ) poss.add(c1);
            System.out.println("row " + row + " col " + col);
        }

        if(presentCoord.col != 0 ) {
            int row = presentCoord.row,  col = presentCoord.col-1;
            Coord c1 = new Coord(row, col);
            if(!visited.contains(c1) && board[row][col] == letter ) poss.add(c1);
            System.out.println("row " + row + " col " + col);
        }

        if(presentCoord.row != board.length -1  ) {
            int row = presentCoord.row +1,  col = presentCoord.col;
            Coord c1 = new Coord(row, col);
            if(!visited.contains(c1) && board[row][col] == letter ) poss.add(c1);
            System.out.println("row " + row + " col " + col + board[row][col]);
        }

        if(presentCoord.col != board[0].length- 1 ) {
            int row = presentCoord.row,  col = presentCoord.col + 1;
            Coord c1 = new Coord(row, col);
            if(!visited.contains(c1) && board[row][col] == letter ) poss.add(c1);
            System.out.println("row " + row + " col " + col + board[row][col] + letter);
        }

        for(Coord i : poss) System.out.println(i.row + i.col);
        return poss;
    }

}

class Coord{
    int row;
    int col;

    Coord(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return row == coord.row &&
                col == coord.col;
    }

    @Override
    public int hashCode() {

        return Objects.hash(row, col);
    }
}
