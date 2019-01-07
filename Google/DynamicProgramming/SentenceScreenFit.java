package Google.DynamicProgramming;

public class SentenceScreenFit {
    public static void main(String[] args) {
        String[] sentence = {"a", "bcd", "e"};
        String[] s2 = {"hello", "world"};
        String[] s3 = {"I", "had", "apple", "pie"};
        String[] s4 = {"f", "p", "a"};
        String[] s5 = {"a", "b", "c"};

        SentenceScreenFit ssf = new SentenceScreenFit();
        System.out.println(ssf.wordsTyping(sentence, 3, 6) + " ---");
        // System.out.println(ssf.wordsTyping(s2,2,8)+ " ---");
        // System.out.println(ssf.wordsTyping(s3,4,5) + " ---");
        // System.out.println(ssf.wordsTyping(sentence,4,6)+ " ---");
        System.out.println(ssf.wordsTyping(s5, 3, 1) + " ---");

    }

    private int wordsTyping(String[] s, int row, int col) {
        StringBuilder str = new StringBuilder();
        for(String word : s){
            str.append(word + " ");
        }

        int pos = 0;
        int len = str.length();

        for(int i = 0; i < row; i++){
            //adding col to check if words fit neatly in the column
            pos += col;

            if(str.charAt(pos%len) == ' '){
               //moving on to the next line
                pos++;
            }
            else {
                // decrement pos till we find a space
                //we decrement because those spaces cannot be used
                while(pos > 0 && str.charAt((pos -1 ) % len) != ' ') pos --;
            }
        }
        return pos/len;
    }




    public int wordsTypingNonWorkingSoln(String[] sentence, int rows, int cols) {
        int wc = 0, fc = 0;
        int i = 0, j = 0;
        String[][] fill = new String[rows][cols];

        while (i < rows) {
            while (j < cols) {
                String word = sentence[wc];
                //incrementing word count once word is used and if we reach the end of the sentence then reassign wc to start of sentence
                wc++;
                System.out.println("word " + word);
                int wl = word.length();
                int wEnd = j + wl;
                System.out.println("wend " + wEnd);
                if (wEnd <= cols) {
                    if (wEnd + 1 > cols - 1) {
                        //   fill = fillArray(fill, i , j , word);
                        j = 0;
                        i++;
//                        if(i >= rows) break;
                    } else {
                        //  fill = fillArray(fill, i , j , word);
                        j = wEnd + 1;
                        System.out.println("i " + i + " j " + j);
                    }
                } else {
                    j = wl;
                    i++;
                    System.out.println("i " + i + " j " + j);

                    // fill = fillArray(fill, i , j ,word);
                }

                if (wc == sentence.length) {
                    wc = 0;
                    fc++;
                    System.out.println(fc);
                }
                if (i >= rows) break;
            }
        }

        return fc;
    }
}
