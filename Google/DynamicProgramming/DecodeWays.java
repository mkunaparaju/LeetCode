package Google.DynamicProgramming;

public class DecodeWays {

    public static void main(String[] args) {
        String in1 = "12";
        String in2 = "1234";

        DecodeWays dw = new DecodeWays();

        System.out.println(dw.numDecodingsRecursive("31"));
    }


    public int numDecodingsRecursive(String in) {

        if( in == null ||in.length() ==0 ) return 1;

        if( in.length() == 1 ) {

            return (Integer.parseInt(in) == 0)? 0: 1;
        }


        int ways = 0;
        int length = in.length();

        if(in.charAt(in.length() - 1) != '0') ways = numDecodingsRecursive(in.substring(0, length - 1)) ;

        if(in.charAt(length-2) == '1' || (in.charAt(length - 2) == '2' && in.charAt(length - 1) < '7')){
            ways += numDecodingsRecursive(in.substring(0, length - 2));
        }

        return ways;
    }

    public int numDecodings(String in) {

        if(in.length() ==0 || in == null || in.charAt(0) == '0' ) return 0;
        if(in.length() == 1) return 1;
        int count [] = new int [in.length()];
        count[0] = 1;

        if(Integer.parseInt(in.substring(0,2)) > 26) {
            if(in.charAt(1) == '0') count[1] = 0;
            else count[1] = 1;
        }
        else{
//            System.out.println("inhere");
            if(in.charAt(1) == '0') count[1] = 1;
            else count[1]=2;
        }

//        System.out.println(count[0] + " " + count[1]);
        for(int i = 2; i < in.length();i ++){
            if(in.charAt(i) !='0') count[i] = count[i] + count[i-1];

            int val = Integer.parseInt(in.substring(i-1,i+1));
            if(val >= 10 && val < 27){
                count[i] = count[i] + count[i-2];
            }
        }

        return count[in.length()-1];
    }

}
