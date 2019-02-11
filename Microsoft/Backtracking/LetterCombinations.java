package Microsoft.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        String in = "23";
        LetterCombinations lc = new LetterCombinations();

        System.out.println(lc.letterCombinations(in));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> numberMap = new HashMap<>();
        numberMap.put('0', " ");
        numberMap.put('1', "*");
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5', "jkl");
        numberMap.put('6', "mno");
        numberMap.put('7', "pqrs");
        numberMap.put('8', "tuv");
        numberMap.put('9', "wxyz");

        return letterCombinations(digits, numberMap);
    }

    private List<String> letterCombinations(String digits, HashMap<Character, String> numberMap) {

        if (digits.length() == 0 || digits == null) return Collections.emptyList();

        char startDigit = digits.charAt(0);
        System.out.println("init char " + startDigit);
        String alphabets = numberMap.get(startDigit);
        System.out.println("alphabets " + alphabets);
        List<String> output = new ArrayList<>();
        List<String> outForOther = letterCombinations(digits.substring(1), numberMap);

        for (int i = 0; i < alphabets.length(); i++) {
            if (outForOther.size() == 0) output.add(alphabets.substring(i, i + 1));
            else {
                for (String combo : outForOther) {
                    System.out.println("combo " + combo);
                    output.add(alphabets.charAt(i) + combo);

                }
            }
        }
        return output;
    }

}
