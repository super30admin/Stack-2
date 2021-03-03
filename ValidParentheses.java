// Time Complexity : O(n), n = size of string
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a stack to add the starting brackets, and when an end bracket is found, pop from the stack to check if it matches. If the stack if empty and an ending bracket is encountered or length of string is odd, then return false.

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(st.isEmpty() && (curr == ')' || curr == '}' ||  curr == ']') ){
                return false;
            }
            
            if(curr == '(' || curr == '{' || curr == '['){
                st.add(curr);
            } else{
                char par = st.pop();
                if((par == '(' && curr != ')' ) || (par == '{' && curr != '}' )  || (par == '[' && curr != ']' ) ){
                    return false;
                }
            }
        }
        
        if(st.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
}
