// Time Complexity : O(N)
// Space Complexity : O(N) //stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            if(s.length()%2 == 1  )  return false;
            Stack<Character> st = new Stack<>();
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == ')') {
                    if(!st.isEmpty()) {
                        char c = st.pop();
                        if(c != '(') return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if(!st.isEmpty()) {
                        char c = st.pop();
                        if(c != '{') return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if(!st.isEmpty()) {
                        char c = st.pop();
                        if(c != '[') return false;
                    }
                } else {
                    st.push(s.charAt(i));
                }
            }
            return st.isEmpty();
        }
    }
}
