package Pramp;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/*
https://www.pramp.com/challenge/O5PGrqGEyKtq9wpgw6XP
 */
public class ValidSudoku {

    public static void main(String[] args) {

        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        return true;

    }

}
