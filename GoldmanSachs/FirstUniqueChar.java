package GoldmanSachs;

public class FirstUniqueChar {

    public static void main(String[] args) {
        FirstUniqueChar fc = new FirstUniqueChar();
        System.out.println(fc.firstUniqChar("adaad"));
    }

    public int firstUniqChar(String s) {
        int counter [] = new int [26];
        for (char c:s.toCharArray()) counter[c-'a']++;
        for (char c: s.toCharArray()) {
            if (counter[c-'a']==1) return s.indexOf(c);
        }
        return -1;
    }
}
