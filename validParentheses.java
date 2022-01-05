// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            switch(c) {
                case '(' :
                        stack.push(c);
                        break;
                case '[' :
                        stack.push(c);
                        break;
                case '{' :
                        stack.push(c);
                        break;
                case ')' :
                        if (isDescripancyFound('(' , stack)) {
                            return false;
                        } 
                        stack.pop();
                        break;
                case ']' :
                        if (isDescripancyFound('[', stack)) {
                            return false;
                        } 
                        stack.pop();
                        break;
                case '}' :
                        if (isDescripancyFound('{', stack)) {
                            return false;
                        } 
                        stack.pop();
                        break;
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isDescripancyFound(Character c, Stack<Character> s) {
        if (s.isEmpty() || s.peek() != c) {
            return true;
        }
        
        return false;
    }
}