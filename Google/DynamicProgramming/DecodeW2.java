package Google.DynamicProgramming;

public class DecodeW2 {
    public static void main(String[] args) {
        DecodeW2 d2 = new DecodeW2();

        System.out.println(d2.numDecodingsIter("227"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 1;
        if (s.length() == 1) return (s == "0") ? 0 : 1;

        int ways = 0;

        if (s.charAt(s.length() - 1) != '0') ways += numDecodings(s.substring(0, s.length() - 1));
        if (s.charAt(s.length() - 2) == '1' || (s.charAt(s.length() - 2) == '2' && s.charAt(s.length() - 1) < '7'))
            ways += numDecodings(s.substring(0, s.length() - 2));

        return ways;
    }


    public int numDecodingsIter(String in) {
        int ways = 0;
        int[] helper = new int[in.length()];
        if (in == null || in.length() == 0) return 1;

        helper[0] = in.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i< in.length(); i++){
            if(in.charAt(i-1) == '1') {
                if(in.charAt(i) == '0') helper[i] = helper[i-1];
                else{
                    helper[i] = helper[i-1] +1;
                }
            }else if(in.charAt(i-1) == '2'){
                if(in.charAt(i) == '0') helper[i] = helper[i-1];
                else {
                    if(in.charAt(i) < '7')helper[i] = helper[i-1] + 1;
                    else helper [i] = helper [i-1];
                }
            }   else{
                helper[i] = helper[i-1];

            }

        }

        return helper[in.length()-1];

    }
}
