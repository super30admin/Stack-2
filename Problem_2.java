// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// replace the opening with closing bracket and if closing then check if st.peek is same or not, at the end check the stack is empty or not.
// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            }else if(c == '{'){
                st.push('}');
            }else if(c == '['){
                st.push(']');
            }else{
                if( st.isEmpty() || c != st.pop()) return false;
            }
        }
        return st.isEmpty();
    }
}