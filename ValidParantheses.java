public class ValidParantheses {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(')');
            else if(ch=='[') st.push(']');
            else if(ch=='{') st.push('}');
            else if(st.isEmpty() || st.pop()!=ch) return false;
        }
        if(st.isEmpty()) return true;
        return false;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
