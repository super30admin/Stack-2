//The idea here is use a stack because the order of the braces is required.
//For this, for every opening brace, we push corresponding closing brace into the stack. Whenever we encounter a closing brace, we see if it is on the top of the stack, if it is, then we continue, else we return false
//When we go through the string and we still have elements in stack, that means we have extra parantheses, so we return false
//If stack is empty, we return true;
//Time complexity: O(n)
//Space Complexity: O(n)
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(')');
            } else if(ch == '{'){
                st.push('}');
            } else if(ch == '['){
                st.push(']');
            } else if(st.isEmpty() || ch != st.pop()){
                return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}