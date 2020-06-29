// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;
public class ValidParenthesis {
    static  boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i <len; i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stk.isEmpty() || stk.peek() != '(') return false;
                stk.pop();
            } else if(c == ']') {
                if(stk.isEmpty() || stk.peek() != '[') return false;
                stk.pop();
            } else if(c == '}') {
                if(stk.isEmpty() || stk.peek() != '{') return false;
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }
    public static void main(String[] args) {
        String str = "([)]";
        System.out.println("Is \"" + str+ "\" valid? " + isValid(str));
    }
}
