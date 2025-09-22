// Time Complexity: O(n) — single pass; each push/pop is O(1).
// Space Complexity: O(n) — stack may hold up to n opening brackets in the worst case.

// Scan the string: on '(', '{', '[', push the matching expected closer (')', '}', ']') onto the stack.
// On any other char, ensure stack isn’t empty and equals st.pop(); if not, return false immediately.
// After the loop, return true only if the stack is empty (all opens properly closed).

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                st.push(')');
            } else if(c == '{'){
                st.push('}');
            } else if(c == '['){
                st.push(']');
            } else if(st.isEmpty() || c != st.pop()){
                return false;
            }
        }

        return st.isEmpty();
    }
}
