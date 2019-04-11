package Amazon.ArraysAndStrings;

import java.util.HashMap;

public class FirstUnique {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";

        int firstUnique = getFirstUnique(s1);
        System.out.print(firstUnique != -1? "index = "+ firstUnique : "index not avaialble. ");
    }

    private static int getFirstUnique(String s) {
        int index = 0;
        int count [] = getCount(s);

        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 97] == 1) return i;
        }
        return -1;
    }

    private static int[] getCount(String s) {
        int [] count = new int [26];
        for( int i = 0; i < s.length(); i++){
            System.out.println(s.charAt(i)- 97);
            count[s.charAt(i)- 97] = count[s.charAt(i)- 97] + 1;
        }

        return count;
    }
}
