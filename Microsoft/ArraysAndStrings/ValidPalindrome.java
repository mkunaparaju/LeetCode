package Microsoft.ArraysAndStrings;

public class ValidPalindrome {

    public static void main(String[] args) {

        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));

    }

    public boolean isPalindrome(String s) {
        String [] words =  s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split(" ");
        String concat = "";
        for(String s1: words) {
            concat+=s1;
           // System.out.println(s1);
        }
        int pStart = 0;
        int pEnd = concat.length() -1;


        while(pStart < pEnd){
           // System.out.println(concat.charAt(pStart) + " " + concat.charAt(pEnd));
            if(concat.charAt(pStart) != concat.charAt(pEnd)) return false;
            pStart++;
            pEnd--;
        }
        return true;

    }
}
