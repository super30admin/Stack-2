// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> st = new Stack<>(); 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')
                st.push(')');
            else if(ch == '{')
                st.push('}');
            else if(ch == '[')
                st.push(']');
            else if(st.isEmpty() || st.pop() != ch)
                return false;
        }
        if(!st.isEmpty())
            return false;
        return true;
    }
}