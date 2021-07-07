// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{'){
                stack.add('}');
            } else if(c == '('){
                stack.add(')');
            } else if(c == '['){
                stack.add(']');
            } else {
                if(stack.isEmpty() || stack.pop() != s.charAt(i)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
