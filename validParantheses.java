import java.util.Stack;

// Time Complexity : Add : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ValidParantheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        isValid(s);
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();  // S.C - O(N)
        for(int i=0; i<s.length(); i++){  // T.C - O(N)
            char c = s.charAt(i);
            if(c == '(')
                st.push(')');  // push the closing braces
            else if(c == '[')
                st.push(']');
            else if(c == '{')
                st.push('}');
            else {
                if(st.isEmpty() || st.pop() != c)
                    return false;
            }
        }

        return (st.isEmpty()) ? true : false;
    }
}

