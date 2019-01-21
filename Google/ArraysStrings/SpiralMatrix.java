package Google.ArraysStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int m3[][] = {{}};
        int [][] m4 = {{2,5,8},{4,0,-1}};
        int [][] m5 = {{1,2},{3,4},{5,6}};

        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.spiralOrder(m5));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();

        if (matrix.length == 0) return spiralList;
        int vRowCount = 0;
        int vColCount = 0;

        int rowCount = matrix.length - 1;
        int colCount = matrix[0].length - 1;

        while (vRowCount <= rowCount / 2 && vColCount <= colCount / 2) {

//           System.out.println("vRow " + vRowCount + " VCOL " + vColCount);
            for (int i = vColCount; i <= colCount - vColCount; i++) {
                spiralList.add(matrix[vRowCount][i]);
//                System.out.println(matrix[vRowCount][i]);

            }
//            printList(spiralList);
            for (int i = vRowCount + 1; i < rowCount - vRowCount; i++) {
                spiralList.add(matrix[i][colCount - vColCount]);
//                System.out.println(matrix[i][colCount-vColCount -1]);

            }
//            printList(spiralList);
            if (vRowCount < rowCount - vRowCount) {


                for (int i = colCount - vColCount; i >= vColCount; i--) {
                    spiralList.add(matrix[rowCount - vRowCount][i]);

                }
            }
//            printList(spiralList);
            if (vColCount < colCount - vColCount) {
                for (int i = rowCount - vRowCount - 1; i >= vRowCount + 1; i--) {
                    spiralList.add(matrix[i][vRowCount]);

                }
            }
//            printList(spiralList);
            vRowCount++;
            vColCount++;
        }
        return spiralList;
    }

    private void printList(List<Integer> spiralList) {
        for (int i : spiralList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
