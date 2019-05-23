package Microsoft.ArraysAndStrings;

import Google.DynamicProgramming.VacationDays;

import java.util.ArrayDeque;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid(")"));
    }

    public boolean isValid(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(Character c :s.toCharArray()){



            if(c == '(' || c == '{' || c == '[' ){
                stack.push(c);
            }

            else if(c == ')') {
                if (stack.isEmpty() ||'(' != stack.pop()) return false;
            }

            else if(c == '}') {
                if (stack.isEmpty() ||'{' != stack.pop()) return false;
            }

            else if(c == ']') {
                if (stack.isEmpty() ||'[' != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
