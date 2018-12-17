package Microsoft.ArraysAndStrings;

import com.sun.org.apache.regexp.internal.RE;

public class ReverseString {
    public static void main(String[] args) {
        String in = "A man, a plan, a canal: Panama";
        ReverseString rs = new ReverseString();
       // System.out.println(rs.reverseString(in));

        System.out.println(rs.reverseWords("   a   b "));
    }

    public String reverseString(String s) {
        int pStart = 0;
        int pEnd = s.length() -1;
        StringBuilder sb = new StringBuilder(s);
        while(pStart < pEnd){
            char temp  = sb.charAt(pEnd);
            sb.setCharAt(pEnd, sb.charAt(pStart));
            sb.setCharAt(pStart, temp);


            pStart++;
            pEnd--;
        }
        return sb.toString();
    }

    public String reverseWords(String s){
        if(s == null || s.equals("")) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ");
        for(int i=sArr.length-1; i>=0; i--) {
            if(sArr[i].length() > 0)
                sb.append(sArr[i] + " ");
        }
        return sb.toString().trim();
    }
}
