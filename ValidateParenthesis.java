// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// Iterate over the string, Add opening bracket to stack
// For closing brackets, check top of stack. It should match the type of opening bracket.

class Solution {
    public boolean isValid(String s) {

        if(s == null) return false;

        Stack<Character> st = new Stack();

        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                if( c == ')' && st.pop() != '(') return false;
                else if( c == '}' && st.pop() != '{') return false;
                else if( c == ']' && st.pop() != '[') return false;
            }
        }

        if(!st.isEmpty()) return false;
        return true;
    }
}
