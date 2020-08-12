// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Stack
 1. Push if open brackets
 2. Pop if close brackets and same type.
 */
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        if(s.charAt(0) == '(' || s.charAt(0) == '{' || s.charAt(0) == '['){
            st.push(s.charAt(0));
        }
        else{
            return false;
        }
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[' ){
                st.push(ch);
            }
            else{
                if(!st.isEmpty()){
                    if(ch == ')'){
                        if(st.peek() == '(')
                            st.pop();
                        else
                            return false;
                    }
                    if(ch == ']'){
                        if(st.peek() == '[')
                            st.pop();
                        else
                            return false;
                    }
                    if(ch == '}'){
                        if(st.peek() == '{')
                            st.pop();
                        else
                            return false;
                    }    
                }
                else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' ){
                st.push(')');
            }
            else if(ch == '{' ){
                st.push('}');
            }
            else if(ch == '[' ){
                st.push(']');
            }
            else if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
}