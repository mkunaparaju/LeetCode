package Google.ArraysStrings;

import java.util.spi.LocaleNameProvider;

public class LongestSubStringWithKDistinctWithMap {
    public static void main(String[] args) {
        String in1 = "bacc";
        String in2 = "eceba";
        String in3 = "baalsteeteetvdm";


        LongestSubStringWithKDistinctWithMap lskd = new LongestSubStringWithKDistinctWithMap();
        System.out.println(lskd.lengthOfLongestSubstringKDistinct(in3, 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k==0) return 0;
        int begin = 0, end = 0, uniqueCount = 0, longest = 0;
        int [] map = new int [256]; // all characters array to keep count of characters

        while (end < s.length()) {
            while(end < s.length() && (uniqueCount < k || map[s.charAt(end)] >0)){

                map[s.charAt(end)] ++;
                if(map[s.charAt(end)] == 1) uniqueCount++;
                end++;
            }
            longest = Math.max(longest, (end -begin));

            while(uniqueCount == k){
                map[s.charAt(begin)]--;
                if(map[s.charAt(begin)] == 0) uniqueCount--;
                begin++;
            }
            }
        return longest;
    }
}
