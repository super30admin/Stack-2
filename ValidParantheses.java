// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// WE use the stack to keep track of the opening brackets and push the required for it
// if we find the required bracket , we pop the stack 
//  If the brackets do not match , we push the required bracket into the stack
// Finally, if the stack is empty , it means the brackets are valid

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque();
        for (char c : s.toCharArray()) {
            if (c == '(')
                st.push(')');
            else if (c == '{')
                st.push('}');
            else if (c == '[')
                st.push(']');
            else {
                if (!st.isEmpty() && c == st.peek())
                    st.pop();
                else
                    return false;
            }
        }

        return st.isEmpty();
    }
}