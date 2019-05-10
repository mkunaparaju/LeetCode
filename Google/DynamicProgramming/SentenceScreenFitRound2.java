package Google.DynamicProgramming;

public class SentenceScreenFitRound2 {

    public static void main(String[] args) {
        String[] sentence = {"a", "bcd", "e"};
        String[] s2 = {"hello", "world"};
        String[] s3 = {"I", "had", "apple", "pie"};
        String[] s4 = {"f", "p", "a"};
        String[] s5 = {"a", "b", "c"};
        String[] s6 = {"f", "p", "a"};

        SentenceScreenFitRound2 ssf = new SentenceScreenFitRound2();
//        System.out.println(ssf.wordsTyping(sentence, 3, 6) + " ---");
//         System.out.println(ssf.wordsTyping(s2,2,8)+ " ---");
        System.out.println(ssf.wordsTyping(s3, 4, 5) + " ---");
//         System.out.println(ssf.wordsTyping(sentence,4,6)+ " ---");
//        System.out.println(ssf.wordsTyping(s5, 3, 1) + " ---");
//                System.out.println(ssf.wordsTyping(s6, 8, 7) + " ---");
    }

    private int wordsTyping(String[] s, int row, int col) {
        int pos = 0;
        int r = 0;
        int c = col;
        int count = 0;
        while (pos < s.length) {
//            System.out.println("pos "+ pos);
            String word = s[pos];
            if(word.length() > col) break;
            System.out.println(word);
            int len = (c == word.length()) ? word.length() : word.length() + 1;
//            System.out.println(len);
            if (len <= c) {

                c = c - len;
//                System.out.println("c " + c);
            } else {
                r++;
                c = col;
                c = c - len;
            }
            if (c == 0) {
                row++;
                c = col;

            }
            if (r == row) break;
            System.out.println(pos);
            if (pos == s.length - 1) {
                pos = 0;
                count++;
                System.out.println("count" + count);
            } else pos++;
        }
        System.out.println("count end "+count);
        return count;
    }


}
