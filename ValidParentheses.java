// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            }else if(c == '['){
                st.push(']');
            }else if(c == '{'){
                st.push('}');
            }else if(st.isEmpty() || st.pop() != c){
                return false;
            }
        }

        return st.isEmpty();
    }
}