// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/


class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            if(ch == '(') st.push(')');
            else if(ch == '{') st.push('}');
            else if(ch == '[') st.push(']');
            else if(st.isEmpty() || ch != st.pop()) return false;
            
        }
        
        if(!st.isEmpty()) return false;
        return true;
        
    }
}


/*
class Solution {
    public boolean isValid(String s) {
        
        int len = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            
            if((ch == ')' || ch == '}' || ch == ']')){
                if(st.isEmpty())
                    return false;
            }
            
            if(!st.isEmpty() && (ch == ')' || ch == '}' || ch == ']')){
                if(ch == ')' && st.peek() == '(')
                    st.pop();
                else if(ch == '}' && st.peek() == '{')
                    st.pop();
                else if(ch == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        
            
            if((ch == '(' || ch == '{' || ch == '[') && i == len-1){
                return false;
            }
            
        }
        
        if(st.isEmpty())
            return true;
        else 
            return false;
        
    }
}
*/