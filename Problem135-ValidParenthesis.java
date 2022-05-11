// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i < s.length(); i++){
            // If it is an open bracket, push to the stack.
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                st.push(s.charAt(i));
            //If it is a closing bracket, then stack should atleast have one element to s be a valid string
            else if(!st.isEmpty()){
                //matches the top
                if(s.charAt(i)==')' && st.pop() != '(') return false;
                else if(s.charAt(i)==']' && st.pop() != '[') return false;
                else if(s.charAt(i)=='}' && st.pop() != '{') return false;
            } else {
                //if the current char is not a open bracket and stack is empty, s is not a valid string
                return false;
            }
        }
        return st.isEmpty();
    }
}