//https://leetcode.com/problems/valid-parentheses/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        if(s.length()%2!=0) return false;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(') st.push(')');
            else if(ch=='{') st.push('}');
            else if(ch=='[') st.push(']');
            else if(st.isEmpty() || ch!=st.pop()) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
        
    }
}