import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        //null case check and odd length string check
        if(n == 0 || n % 2 != 0 ) return false;
        
        //here we will store ....
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '{') st.push('}');
            else if(s.charAt(i) == '[') st.push(']');
            else if(s.charAt(i) == '(') st.push(')');
            else if(st.isEmpty() || st.pop() != s.charAt(i)) return false;
        }
        
        if(st.size() == 0) return true;
        
        return false;
    }
}