9// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the entire array only once
//Space Complexity: O(n) since we are using an extra stack

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        char[] strs = s.toCharArray();
        
        for(char c : strs){
            switch(c)
            {
                case '(':
                    st.push(')');
                    break;
                case '{':
                    st.push('}');
                    break;
                case '[':
                    st.push(']');
                    break;
                default:
                    if(st.isEmpty() || st.pop() != c) return false;
                    break;
            }
        }
        return st.isEmpty();
    }
}