package Google.SortAndSearch;

import java.util.HashMap;

public class MinWinSubtring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
/*
        "bdab"
        "ab"
*/
        MinWinSubtring ms = new MinWinSubtring();
        System.out.println(ms.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int length = t.length();
        int count = 0;
        int minWin = s.length() + 1;
        String minString = "";

        int p1 = 0, p2 = 0;

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!charMap.containsKey(c)) charMap.put(c, 1);
            else charMap.put(c, charMap.get(c) + 1);
        }

        while (p1 < s.length() && p2 < s.length()) {
//            System.out.println( "p1 " + p1 + " p2 " + p2);
//            System.out.println(p2);
            if (charMap.containsKey(s.charAt(p2))) {
                charMap.put(s.charAt(p2), charMap.get(s.charAt(p2)) - 1);
                if (charMap.get(s.charAt(p2)) >= 0) count++;
            }
//            System.out.println("count " + count);
            while (count == length) {
                if (minWin > p2 - p1) {
                    minWin = p2 - p1;
                    minString = s.substring(p1, p2 + 1);
                }
//                System.out.println(minWin + " p1 " + p1 + " p2 " + p2);
//                System.out.println(minString);
//                    System.out.println(p1);
                if (charMap.containsKey(s.charAt(p1))) {
//                        System.out.println("p1dfdffgfdgd");
                    charMap.put(s.charAt(p1), charMap.get(s.charAt(p1)) + 1);
                    if (charMap.get(s.charAt(p1)) > 0) count--;
//                        System.out.println(s.charAt(p1) + " " + charMap.get(s.charAt(p1)));
                }
                p1++;
            }
        p2++;
    }

        return minString;
}
}
