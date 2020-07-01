// Time Complexity : O(n) where n is the string length
// Space Complexity : O(n) where n is the string length (Stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: For each of the opening brackets, push a closing bracket as a representation. Since
we will encounter same type of closing brackets for each of the opening brackets. If we encounter same type of closing bracket for each of the opening
bracket, pop the equivalent bracket from the stack. If the stack is empty at the end, it is a balanced parenthesis else it is not.
*/
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')                                                                // For each type of the opening bracket
                stk.push(')');
            else if(c == '{')
                stk.push('}');                                                          // Push the equivalent closing bracket as a representation
            else if(c == '[')
                stk.push(']');
            else
            if(!stk.isEmpty()){                                                         // If it reaches here implies closing bracket is incoming
                    if(stk.peek() != c){                                                // Closing bracket type is different
                        return false;
                    } else {
                        stk.pop();                                                          // Same type of brackets
                    }
                } else {
                return false;}                                                              // Stack is already empty
        }
        return (stk.isEmpty());                                                         // Return if the stack is empty now or not
    }
}