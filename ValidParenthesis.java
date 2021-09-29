/*
Time: O(n) need to traverse complete input
Space: O(n) using stack, max length could be ~n
*/
class Solution {
    public boolean isValid(String s) {
        //Base:
        if(s==null || s.length()==0){
            return true;
        }
        
        //Logic:
        //Rather than storing in stack, we can make counter updates + or -
        Stack<Character> st = new Stack<>();
        // char[] c 
        
        //Challenge=> () [] {} -three types of brackets
        //
        int n = s.length();
        int cnt = 0;
        for(int i=0; i< n; i++){
            if(s.charAt(i)=='('){
                st.push(')');
            }else if(s.charAt(i) == '{'){
                st.push('}');
            }else if(s.charAt(i) == '['){
                st.push(']');
            }
            else if(st.isEmpty() || st.pop()!=s.charAt(i)){
                    return false;
            }
        }
        // if(!s.isEmpty && )
        return st.isEmpty();
        
    }
}
