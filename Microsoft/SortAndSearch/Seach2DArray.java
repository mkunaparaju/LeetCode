package Microsoft.SortAndSearch;

public class Seach2DArray {

    public static void main(String[] args) {
        int [][] matrix = { {1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50} };
        int [][] m2 = {{1}};
        int target = 1;

        Seach2DArray s2 = new Seach2DArray();
        System.out.println(s2.searchMatrix(m2,target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean elemExists = false;
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        for(int i = 0; i < matrix.length; i++){
            System.out.println(matrix[i][0]);
            if(target>= matrix[i][0] && target<= matrix[i][matrix[0].length -1]){
                return bst(matrix[i], target);
            }


        }
        return elemExists;

    }

    private boolean bst(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length -1;
        int mid = (start+end)/2;
//        System.out.println(matrix[mid]);
        while(start<=end){
            if(matrix[mid] == target) return true;
            System.out.println(matrix[mid] + target);
            if(target < matrix[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            mid = (start+end)/2;
        }

        return false;
    }
}
