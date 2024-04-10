// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
//Approach : we need the last-in bracket type to be resolved first, hence we need a stack.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(c == '('){
                st.add(')');
            }
            else if(c == '['){
                st.add(']');
            }
            else if(c == '{'){
                st.add('}');
            }
            else if(st.isEmpty() || c != st.pop()){
                return false;
            }  
        }

        return st.isEmpty() ? true : false;
    }
}