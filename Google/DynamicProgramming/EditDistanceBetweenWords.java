package Google.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;

public class EditDistanceBetweenWords {
    public static void main(String[] args) {

//        String word1 = "horse", word2 = "ros";
        String word1 = "intention", word2 = "execution";

        EditDistanceBetweenWords ed = new EditDistanceBetweenWords();
        System.out.println(ed.minDistance(word1,word2));
    }

    public int minDistance(String word1, String word2) {
//        return minDistance(word1, word2, word1.length(), word2.length());
        int [][] dp = new int [word1.length()][word2.length()];

        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return minDistanceMemo(word1,word2, word1.length(), word2.length(), dp);
    }

    private int minDistanceMemo(String word1, String word2, int m, int n, int[][] dp) {
        if(m==0) {
            return n;
        }
        if(n==0) {
            return m;
        }

        if(dp[m-1][n-1] != -1) return dp[m-1][n-1];
        if(word1.charAt(m-1) == word2.charAt(n-1)) {
            dp[m-1][n-1] = minDistanceMemo(word1,word2,m-1,n-1,dp);
            return dp[m-1][n-1];
        }

        dp[m-1][n-1] = 1 + Math.min(minDistanceMemo(word1,word2,m,n-1, dp),
                Math.min(minDistanceMemo(word1,word2,m-1,n,dp), minDistanceMemo(word1,word2, m-1,n-1,dp)));

        return dp[m-1][n-1];
    }


    private int minDistance(String word1, String word2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (word1.charAt(m -1) == word2.charAt(n - 1)) return minDistance(word1, word2, m - 1, n - 1);

        int insertWays = minDistance(word1, word2, m, n - 1);
        int deleteWays = minDistance(word1, word2, m - 1, n);
        int replaceWays = minDistance(word1, word2, m - 1, n - 1);

        return Math.min(Math.min(insertWays, deleteWays), replaceWays) + 1;
    }


    private int minDistanceDp(String word1, String word2){
        int [][] dp = new int [word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        
    }
}
