package Stack2;

import java.util.Stack;

public class ValidParantheses {
    /* Created by palak on 8/3/2021 */

    /**
     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)    return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
