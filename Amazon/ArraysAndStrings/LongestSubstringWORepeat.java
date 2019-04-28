package Amazon.ArraysAndStrings;

import java.util.HashSet;

public class LongestSubstringWORepeat {
    public static void main(String[] args) {

        String s = "abcabcbb";
        String s2 = "pwwkew";
        String s3 = "bbbbbb";

        LongestSubstringWORepeat ls = new LongestSubstringWORepeat();

        System.out.println(ls.lengthOfLongestSubstring(s3));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            HashSet<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {

                char c = s.charAt(j);
                if (!charSet.contains(c)) {
//                    System.out.println(c);
                    len++;
                    charSet.add(c);
                    if (j == s.length() - 1) {
                        if (len > maxLen) return len;
                    }
                } else {
//                    System.out.println(len);
                    break;
                }
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }


}
