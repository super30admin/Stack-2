import java.util.Stack;


//Tc: O(n)
//Sc: O(n)
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0 ) {
            return false;
        }
        char [] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : charArr) {
            if ( c == '(') {
                stack.push(')');
            } else if ( c == '{') {
                stack.push('}');
            } else if ( c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();

    }
}