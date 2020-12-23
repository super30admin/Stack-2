// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Leetcode : 20
//Approach: Stack

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
         
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){ st.push(')'); }
            else if(c == '{') {st.push('}'); }
            else if(c == '[') {st.push(']'); }
            else if(st.isEmpty() || st.pop()!= c ) return false;
            
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}