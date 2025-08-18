// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : For each open parenthesis, add to stack. For each close parenthesis, check if corresponding open 
///parenthesis is at top of stack, if yes pope lese return false;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else if(ch==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
             else if(ch=='}'){
                if(!st.isEmpty() && st.peek()=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
             else if(ch==']'){
                if(!st.isEmpty() && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}