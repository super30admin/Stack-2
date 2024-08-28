import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) { //O(2*n) T.C
        Stack<Character> st = new Stack<>(); //O(n) S.C
        for(int i = 0; i < s.length(); i++) { //traverse the input string
            char c = s.charAt(i); //take the character out
            if(c == '(' || c == '[' || c == '{') { //if the current char is any of the opening bracket
                st.push(c); //push into stack for future processing
            } else { //else if it is any of the closing bracket
                if(st.isEmpty()) return false;  // Stack must not be empty to pop
                char top = st.pop(); //pop from stack
                if(c == ')' && top != '(') return false; //if current char is ) but top is not (, false
                if(c == ']' && top != '[') return false; //same for ] and [
                if(c == '}' && top != '{') return false; //same for } and {
            }
        }

        return st.isEmpty();  // Stack must be empty at the end for a valid sequence
    }

    public static void main(String[] args) {
        String s1 = "[]{([()])}";
        System.out.println("Does " + s1 + " have balanced parentheses? " + isValid(s1));

        String s2 = "[{()]}";
        System.out.println("Does " + s2 + " have balanced parentheses? " + isValid(s2));
    }
}
