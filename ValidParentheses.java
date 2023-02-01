// Time Complexity : O(n)
// Space Complexity : O(n)
/*
 * we put the corresponding closing element to the stack. whenever we get
 * the closing element we compare to the last input if they dont match
 * return false. 
 */

class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        if(s.length() % 2 != 0) return false;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else if(st.isEmpty() || c != st.pop()) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}