//TIme Complexity : O(n) n is the numberof elements in T
//Space Complexity : O(n) since I'm using stack
// LeetCode : passed all tests.


class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        Stack<Character> st  = new Stack<>();
        for(int i = 0;i<s.length();i++){
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
            else if(st.isEmpty() || c!=st.pop()){
                return false;
            }
        }
        
        return st.isEmpty();
    }
}