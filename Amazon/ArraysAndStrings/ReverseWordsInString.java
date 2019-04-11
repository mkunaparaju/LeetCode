package Amazon.ArraysAndStrings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        char in[] = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        char[] out = getReverseWords(in);
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i]);
        }
    }

    private static char[] getReverseWords(char[] in) {
        in = getReverseString(in,0, in.length-1);
        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i]);
        }
        int start = 0;
        for(int i = 0; i< in.length; i++){
            char temp = in[i];
            if(temp == ' ' ){
                System.out.println(i);
                in = getReverseString(in, start, i-1);
                start = i+1;
            }
            else if(i == in.length - 1) {
                in = getReverseString(in, start, i);
            }

        }


        return in;
    }

    private static char[] getReverseString(char[] in, int start, int end) {
        while (start < end) {
            char s = in[start];
            in[start] = in[end];
            in[end] = s;

            start++;
            end --;
        }
        return in;
    }


}
