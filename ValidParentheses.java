package Stack2;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else{
                if(st.isEmpty() || (c==')' && st.peek() != '(') ||
                        (c=='}' && st.peek() != '{') ||
                        (c==']' && st.peek() != '['))
                {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
