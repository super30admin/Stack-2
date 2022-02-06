// Time Complexity: O(n)
// Space Complexity: O(n)
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
       
        Stack<Character> st = new Stack<>();
        
        for(char c: s.toCharArray())
        {
            if(c == '(')
            {
               st.push(')');
            }
            else if(c == '[')
            {
                st.push(']');
            }
            else if(c == '{')
            {
                st.push('}');
            }
            else if(st.isEmpty() || st.pop() != c) // empty is needed if s == ')'
                return false;
        }
        
       return st.isEmpty();
    }
}
// Note: if there is a single bracket only use counter
// count++ for opening
// count-- for closing
// if -ve count return false
// else return count == 0 