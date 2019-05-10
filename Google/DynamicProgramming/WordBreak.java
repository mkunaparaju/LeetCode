package Google.DynamicProgramming;

import java.util.*;

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
        System.out.println(wb.wordBreakDp(s2, wordDict2));
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

    HashMap<String,Boolean> containsMap = new HashMap<>();
    public boolean wordBreakRec(String s, List<String> wordDict){
        if(wordDict.contains(s)) return true;

        if(containsMap.containsKey(s)) return containsMap.get(s);

        boolean contains = false;
        boolean split = false;
        for(int i = 0; i < s.length(); i++){
            contains = wordDict.contains(s.substring(0, i+1));
            if(contains){
                split = wordBreakRec(s.substring(i+1), wordDict);
            }
            if(contains && split) return true;
        }
        return contains&&split;
    }


    public Boolean wordBreakDp(String s , List<String> wordDict){
        boolean [] arr = new boolean[s.length() +1];
        arr[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(arr[i]){
                for(int j = i+1; j <= s.length(); j++){
                    if(wordDict.contains(s.substring(i,j))) arr[j] = true;
                }
            }
        }
        return arr[s.length()];
    }
}
