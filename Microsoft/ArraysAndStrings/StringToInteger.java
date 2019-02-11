package Microsoft.ArraysAndStrings;

public class StringToInteger {

    public static void main(String[] args) {
        String i = "-91283472332";
        String i2 = "42";
        String i3 = "words and 987";
        String i4 = "       -42";
        String i5 = "3.56";

        StringToInteger sti = new StringToInteger();
        System.out.println(sti.atoi(i5));

    }

    private int atoi(String s) {

        //case "" empty
        if(s.length() == 0) return 0;

        //cosidering decimals like 3.56
        double sol = 0;
        int i = 0;
        int len = s.length();

        //getting past white spaces. Use (i) to keet pprack of the index where nums or alphas start
        while(s.charAt(i) == ' ') {
            i++;
            if(i >= len) return 0;
        }
        char c = s.charAt(i);
        int sign = 0;

        //findind out hte sign of the number positive or negitive

        if(c - '0' >= 0 && c - '0' <= 9 || c == '-' || c == '+') {
            if(s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else {
                if(s.charAt(i) == '+') {
                    sign = 1;
                    i++;
                } else {
                    sign = 1;
                }
            }

        } else {
            return 0;
        }

        //build the actual number. This removes decimals
        while(i < len && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            sol *= 10;
            sol += (s.charAt(i) - '0');
            i++;
        }
        sol = sol * sign; // returns positive or negitive
        if(sol > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sol < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) sol;
    }
}
