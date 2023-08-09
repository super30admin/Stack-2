import java.util.Stack;
import java.util.Scanner;

public class ValidParenthesesStack {

        // Stack - balancing Last Ins First - Time O(n) and Space O(n)

        public boolean isValid(String s) {

            // null case
            if(s == null)  {
                return true;
            }

            // odd number of characters in string s means invalid string as right matching can only happen with even number
            if(s.length()%2 != 0)  {

                return false;
            }

            // Stack to balance last in characters first
            Stack<Character> st = new Stack<>();

            // iterate over string s
            for(int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                // for open brackets, push corresponding close brackets into stack for future check with actual close brackets in string s
                if(c == '(')    {

                    st.push(')');
                }

                else if(c == '{') {

                    st.push('}');
                }

                else if(c == '[') {

                    st.push(']');
                }

                // stack is empty if the first close bracket comes before the first open bracket, and string is invalid
                // or if top (last in)element in stack does not match with current character of string, there is invalidity
                else if(st.isEmpty() || c != st.pop()) {

                    return false;
                }
            }

            // if stack is empty after iteration over string, every open bracket is rightly closed or invalid parentheses otherwise
            return st.isEmpty();
        }

        public static void main(String[] args) {

            ValidParenthesesStack obj = new ValidParenthesesStack();

            Scanner scanner = new Scanner(System.in);

            System.out.println("parentheses in string: ");
            String s = scanner.nextLine();

            boolean answer = obj.isValid(s);

            System.out.println("Are these valid parentheses? : " + answer);
        }

}

/*
TIME COMPLEXITY = O(n)

iteration over character parentheses of string - O(n)

SPACE COMPLEXITY = O(n)

Stack space - O(n)
*/