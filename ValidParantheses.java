// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(c == '('){
                st.push(')');
            }else if(c == '{'){
                st.push('}');
            }else if(c == '['){
                st.push(']');
            }else if(st.isEmpty() || c!=st.pop()){
                return false;
            }
        }

        return st.isEmpty();
    }
}
