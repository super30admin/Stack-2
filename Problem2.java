//Time Complexity: O(n); where n is the length of s.
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2 {

    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        
        for(int i =0; i < n; i++)
        {
            char c = s.charAt(i);
            
            if(c == '{')
                st.push('}');
            
            else if(c == '[')
                st.push(']');
            
            else if(c == '(')
                st.push(')');
            
            else if(st.isEmpty() || c != st.peek())
                    return false;
            
            else 
                st.pop();
        }
        
        return st.isEmpty();
    }
}
