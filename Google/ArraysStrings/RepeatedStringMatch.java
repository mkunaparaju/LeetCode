package Google.ArraysStrings;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        String in = "abcd";
        String b = "cdabcdab";

        RepeatedStringMatch rsm = new RepeatedStringMatch();

        System.out.println(rsm.repeatedStringMatch(in, b));
    }

        public int repeatedStringMatch(String a, String b) {
            String as = a;
            for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a)
                if (as.indexOf(b) != -1) return rep;
            return -1;
        }
    

    private boolean isSubString(String a, String b) {


        return false;
    }


}
