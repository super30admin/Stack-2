//Time Complexity: O(n) 
//Space Complexity: O(n) 

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s == null)
            return true;

        if(s.length()%2!=0) return false;
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else  if(c == '[') st.push(']');
            else if(st.isEmpty() || c != st.pop()) return false;

        }

        return st.isEmpty();
    }
} 