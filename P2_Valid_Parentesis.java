// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  yes

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(')');
            }
            else if(c == '[') {
                st.push(']');
            }
            else if(c == '{') {
                st.push('}');
            } else {
                if(st.isEmpty() || c != st.peek()) {
                    return false;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()) {
            return false;
        }
        return true;
    }
}