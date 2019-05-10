package Google.DynamicProgramming;

public class DistanceBtwnWords {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ror";

        DistanceBtwnWords sb = new DistanceBtwnWords();
        System.out.println(sb.minDistance(s1,s2));
    }

    public int minDistance(String word1, String word2) {
        int [][] arr = new int [word1.length()][word2.length()];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = 1;
        }
        for(int i = 0; i < arr[0].length; i++){
            arr[0][i] = 0;
        }
        arr[0][0] = 0;

        for(int i = 1; i < word1.length(); i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)) arr[i][j] = arr[i-1][j-1];

                arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i-1][j-1], arr[i][j-1])) + 1;
            }
        }

        return arr[word1.length()-1][word2.length() - 1];

    }


}
