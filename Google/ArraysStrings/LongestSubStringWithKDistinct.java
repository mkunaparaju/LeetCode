package Google.ArraysStrings;

public class LongestSubStringWithKDistinct {
    public static void main(String[] args) {
        String in1 = "bacc";
        String in2 = "eceba";
        String in3 = "baalsteeteetvdm";


        LongestSubStringWithKDistinct lskd = new LongestSubStringWithKDistinct();
        System.out.println(lskd.lengthOfLongestSubstringKDistinct("a", 0));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k==0) return 0;
        int p1 = 0, p2 = 0, unique = 1, longest = 0;
        String tempLongest = "" + s.charAt(p1);
        String longestString = "";

        while (p1 < s.length() && p2 < s.length()) {
            if(p2 == s.length() - 1) {
                System.out.println("temp "+ tempLongest);
                longestString = (longestString.length() < tempLongest.length()) ? tempLongest : longestString;
                break;
            }
            if (unique == k) {
              //  int end = (p2+2 == s.length())? p2+1: p2+2;
                if (tempLongest.contains(s.substring(p2 + 1, p2+2))) {
                    p2++;
                    tempLongest = tempLongest + s.charAt(p2);

                } else {
                   // p2++;
                    p1++;
                    p2 = p1;
                    System.out.println("temp7 "+ tempLongest);
                    longestString = (longestString.length() < tempLongest.length()) ? tempLongest : longestString;
                    unique = 1;
                    tempLongest = "" + s.charAt(p1);
                    System.out.println("temp8 "+ tempLongest + tempLongest.length());
                }
            } else {

                p2++;
                if (tempLongest.contains(s.substring(p2, p2 + 1))) {
                    tempLongest = tempLongest + s.charAt(p2);
                } else {
                    tempLongest = tempLongest + s.charAt(p2);
                    unique++;
                }
            }

        }

        return longestString.length();
    }
}
