/*
20. Valid Parentheses
TC: O(n)
SC: O(n)
For every open bracket push the closing bracket on stack, when a closing brackets comes pop it of. If the closing bracket does not match or if the stack is not empty at the end of the string, then parenthesis are not valid.
*/
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            // For each open bracker push closing bracket
            if(c == '('){
                st.push(')');
            } else if(c == '{'){
                st.push('}');
            } else if(c == '['){
                st.push(']');
            } else if(st.isEmpty() || st.pop() != c){ // If incoming char are not open and does not match stack return false else pop
                return false;
            }
        }

        if(st.isEmpty()) return true; // if stack is empty then all open brackets had closing brackets

        return false;
    }
}
