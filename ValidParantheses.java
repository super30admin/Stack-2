// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We take a stack to push closing parantheses whenever we find opening parantheses in our traversal.
If we come across a closing parantheses and during that time if the stack is empty, meaning, there is
no closing parantheses ie, no opening parantheses was found in the previous occurences or same closing
parantheses does not exist, then its false. Lastly, out stack should be empty if all the parantheses
remain valid, if not, return false.
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(')');
            }
            else if (ch == '{') {
                st.push('}');
            }
            else if(ch == '[') {
                st.push(']');
            }
            else if(st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }
        return st.isEmpty();
    }
}