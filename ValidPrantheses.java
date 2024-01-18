import java.util.Stack;

public class ValidPrantheses {
//        TC:O(n)
//        SC:O(n)
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c =='{' || c=='[')
                st.push(c);
            else
            {
                if(st.empty())
                    return false;
                if(c==')' && st.peek() == '(')
                    st.pop();
                else if(c=='}' && st.peek() == '{')
                    st.pop();
                else if(c==']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        return st.empty();
    }
}
