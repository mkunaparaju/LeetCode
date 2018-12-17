package Microsoft.ArraysAndStrings;

public class StringToInteger {
    public static void main(String[] args) {
        String i = "-91283472332";
        String i2 = "42";
        String i3= "words and 987";

        StringToInteger sti = new StringToInteger();
        System.out.println(sti.atoi(i));

    }

    private int atoi(String str) {
        int output = 0;

        str = str.replaceAll("[a-zA-Z]", "").replaceAll(" ", "");
        try{
            output = Integer.parseInt(str);
        }catch (NumberFormatException nfe) {
            if(str.charAt(0) == '-') return Integer.MIN_VALUE;
            else {

                return Integer.MAX_VALUE;

            }
            }
        return output;
    }
}
