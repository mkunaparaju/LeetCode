package Google.DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;

public class EditDistanceBetweenWords {
    public static void main(String[] args) {

//        String word1 = "horse", word2 = "ros";
//        String word1 = "intention", word2 = "execution";
            String word1 = ""; String word2 = "a";
        EditDistanceBetweenWords ed = new EditDistanceBetweenWords();
//        System.out.println(ed.minDistance(word1,word2));
        System.out.println(ed.minDistanceDp(word1,word2));
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

        int [][] dp = new int [word1.length() + 1][word2.length() + 1];

        //initial fill for row 0 and column 0
        dp[0][0] =0;
        for(int i = 1; i <= word1.length(); i ++) dp[i][0] = i;
        for(int i = 1; i <= word2.length(); i ++) dp[0][i] = i;

        for(int i = 1; i <= word1.length(); i ++ ) {
            for(int j = 1; j <= word2.length(); j++){

                System.out.println(word1.charAt(i-1) + " " + word2.charAt(j-1) );
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];

                    System.out.println(dp[i][j]);
                }
                else    {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                    System.out.println("i " + i + " j "+ j +  " val "+dp[i][j]);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
