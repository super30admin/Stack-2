// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// When we come across open bracket, push is corresponding close bracket into stack
// When we come across closing bracket, check that it matches top of stack
// If string length is odd, return false

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(')');
            else if(ch=='{') st.push('}');
            else if(ch=='[') st.push(']');
            else if(st.isEmpty() || st.pop()!=ch) return false;
        }
        return st.isEmpty();
    }
}