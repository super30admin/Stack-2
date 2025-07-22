// TC : O(N)
// SC : O(N)

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(')');
            } else if(c == '{'){
                st.push('}');
            } else if(c == '['){
                st.push(']');
            } else{
                if(st.isEmpty() || st.peek() != c) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
