// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch=='(')
                st.push(')');
            else if(ch=='{')
                st.push('}');
            else if(ch=='[')
                st.push(']');
            else if(st.isEmpty() || ch!=st.pop())
                return false;
            
        }
        
        return st.isEmpty();
    }
}
