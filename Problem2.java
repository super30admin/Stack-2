// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//use stack to push the opening parenthesis ie (, [, {
//Whenever a closed parenthesis is seen check if top of stack has same opening bracket, if not return false
//if all are valid stack will be empty and true will be returned
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (st.isEmpty()) {
                return false;
            } else if (ch == ')') {
                if (st.pop() != '(')
                    return false;
            } else if (ch == '}') {
                if (st.pop() != '{')
                    return false;
            } else if (ch == ']') {
                if (st.pop() != '[')
                    return false;
            }

        }
        return st.isEmpty();
    }
}
