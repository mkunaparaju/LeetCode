package Microsoft.ArraysAndStrings;

public class ValidPalindrome {

    public static void main(String[] args) {

        ValidPalindrome v = new ValidPalindrome();
        //System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(v.isPalindrome("race a car"));
        //System.out.println(v.isPalindrome("r"));
        System.out.println(v.isPalindrome(""));

    }

    //    public boolean isPalindrome(String s) {
//        String [] words =  s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().split(" ");
//        String concat = "";
//        for(String s1: words) {
//            concat+=s1;
//           // System.out.println(s1);
//        }
//        int pStart = 0;
//        int pEnd = concat.length() -1;
//
//
//        while(pStart < pEnd){
//           // System.out.println(concat.charAt(pStart) + " " + concat.charAt(pEnd));
//            if(concat.charAt(pStart) != concat.charAt(pEnd)) return false;
//            pStart++;
//            pEnd--;
//        }
//        return true;
//
//    }
    public boolean isPalindrome(String s) {
        int p1 = 0; int p2 = s.length()-1;
        s =s.toLowerCase();
        while(p1 < p2){

            if(! (Character.isLetter(s.charAt(p1)) || Character.isDigit(s.charAt(p1))) ){
                p1++;
                continue;
            }
            if(! (Character.isLetter(s.charAt(p2)) || Character.isDigit(s.charAt(p2)))){
                p2--;
                continue;
            }

            if(s.charAt(p1) != s.charAt(p2)) return false;

            p1++; p2--;
        }
        return true;
    }

}
