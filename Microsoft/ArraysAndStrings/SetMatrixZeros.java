package Microsoft.ArraysAndStrings;

public class SetMatrixZeros {

    public static void main(String[] args) {
        SetMatrixZeros sm = new SetMatrixZeros();
        int[][] matrix = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        int m3[][] = {{1}};

        sm.setZeros(m3);
    }


    public void setZeros(int [][] matrix){
        
    }

    public void setZerosIncorect(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (startRow == -1 && startCol == -1) {
                        startRow = i;
                        startCol = j;
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }
        }

        if (startRow != -1 && startCol != -1) {
            convertMarix(matrix, startRow, startCol);


            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    if (matrix[i][j] == -1) {
                        System.out.println(i + " " + j);

                        matrix[i][j] = 0;
                        convertMarix(matrix, i, j);
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    private void convertMarix(int[][] matrix, int row, int col) {

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != -1) matrix[row][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != -1) matrix[i][col] = 0;
        }

    }
}
