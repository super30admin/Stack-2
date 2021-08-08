// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                st.push(')');
            else if(c == '{')
                st.push('}');
            else if(c == '[')
                st.push(']');
            else if(st.isEmpty() || c != st.pop())
                return false;
        }
        if(!st.isEmpty())
            return false;
        return true;
    }
}