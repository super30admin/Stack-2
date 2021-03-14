import java.util.Stack;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
public class ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();

            //iterate over array add openings to stack and then check if there is a corresponding closing and pop value off stack
            for(char c:s.toCharArray()){
                if(c=='(' || c=='{' || c=='['){
                    st.push(c);
                }else if(c==')' && !st.isEmpty() && st.peek()=='('){
                    st.pop();
                }else if(c=='}' && !st.isEmpty() && st.peek()=='{'){
                    st.pop();
                }else if(c==']' && !st.isEmpty() && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }
            return st.isEmpty();// true when all openings have a match closing, and false when a value is left in stack
        }
    }

}
