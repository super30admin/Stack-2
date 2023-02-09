// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
public class ValidParentheses {

        public boolean isValid(String s) {
            
    Stack<Character> st = new Stack<>();
            for (int i =0;i<s.length();i++){
                if (s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '[') {
                    st.push(s.charAt(i));
                } else {
                    if (st.isEmpty()) return false;
                    else if (st.peek() == '(' && s.charAt(i) == ')'){
                        st.pop();
                    }
                    else if (st.peek() == '{' && s.charAt(i) == '}'){
                        st.pop();
                    }
                    else if (st.peek() == '[' && s.charAt(i) == ']'){
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
            return st.isEmpty();        
        }
    
    
}
