// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');                
            }
            else if(c == '{'){
                st.push('}');                
            }
            else if(c == '['){
                st.push(']');                
            }
            else if(st.isEmpty() || st.pop() != c){
                return false;
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}

/* 
//we cannot do it for nested false input
class Solution {
    public boolean isValid(String s) {
        //Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                count++;
            }
            if(c == ')' || c == '}' || c == ']'){
                count--;
            }
        }
        if(count == 0){
            return true;
        }
        return false;
    }
}
*/