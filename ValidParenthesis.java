//Time: O(n)
//Space: O(n)
public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else if(st.isEmpty() || st.pop() != c) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
