package Google.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "applepenapple";
        String s3 = "catsandog";

        String [] wd1 = {"leet", "code"};
        String [] wd2 = {"apple", "pen"};
        String [] wd3 = {"cats", "dog", "sand", "and", "cat"};

        List<String> wordDict1 = new ArrayList<String>(Arrays.asList(wd1));
        List<String> wordDict2 = new ArrayList<String>(Arrays.asList(wd2));
        List<String> wordDict3 = new ArrayList<String>(Arrays.asList(wd3));
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s3, wordDict3));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean pos [] = new boolean[s.length()+1];
        pos[0] = true;

        for(int i = 0; i < s.length(); i++){
            if(pos[i]) {
                for(int j = i+1; j <= s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)) pos[j] = true;
                }
            }
        }
        return pos[s.length()];
    }
}
