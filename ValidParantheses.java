// Time Complexity : O(n)
// Space Complexity : O(n)
// n is the length of given input String
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i <s.length() ; i++){
            Character c = s.charAt(i);
            if(c == '{')
                st.push('}');
            else if(c == '(')
                st.push(')');
            else if(c == '[')
                st.push(']');
            else{
                if(st.isEmpty() || c != st.pop())
                    return false;
            }
        }
        return st.isEmpty();
    }
}
