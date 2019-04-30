package Amazon.ArraysAndStrings;

import java.util.HashMap;

public class FirstNonRepChar {
    public static void main(String[] args) {
        FirstNonRepChar fnr = new FirstNonRepChar();
        System.out.println(fnr.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if(s== null || s.length() == 0) return -1;
        if(s.length() == 1) return 0;

        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(charMap.containsKey(s.charAt(i))){
                int val = charMap.get(s.charAt(i));
                val++;
                charMap.put(s.charAt(i), val);
            } else {
                charMap.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < s.length() ;i++){
            if(charMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
