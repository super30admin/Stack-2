class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else if(c == '(') st.push(')');
            else if(st.empty() || st.pop() != c) return false;
        }
        if(!st.empty()) return false;
        return true;
    }
}
