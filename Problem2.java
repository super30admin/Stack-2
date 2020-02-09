// Time Complexity - O(n) where n is the length of the String
// Space Complexity - O(n) where n is the length of the String
// Stack is used to check that the order of brackets are closed in the order they are open. So, as we traverse the string and find a open bracket, push the closing bracket in the stack. If the closing bracket is found, pop the top of the stack which has to be same as closing bracket for a valid string. 
 
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '{')    st.push('}');
            if(c == '[')    st.push(']');
            if(c == '(')    st.push(')');
            if(c == '}' || c == ')' || c == ']'){
                if(st.isEmpty() || st.pop() != c)   return false; // if stack is empty when closing bracket is found of top of stack is not same
            }
        }
        if(!st.isEmpty())   return false;   // if stack is not empty after the end of traversal.
        return true;
    }
}
