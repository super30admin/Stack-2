// TC: O(n)
// SC: O(n)
public class ParanthesisCheck {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray()){
            // Push if open
            if(c == '(' || c == '[' || c =='{')
                st.push(c);
            // Pop if closing and check if the peek is same opening paranthesis type if not return false 
            else if(!st.isEmpty() && c == ')')
                if(!st.isEmpty() && st.peek() != '(')
                    return false;
                else
                    st.pop();
            else if(!st.isEmpty() && c == '}')
                if(!st.isEmpty() && st.peek() != '{')
                    return false;
                else
                    st.pop();
            else if(!st.isEmpty() && c == ']')
                if(!st.isEmpty() && st.peek() != '[')
                    return false;
                else
                    st.pop();
            else
                return false;
        }
        if(st.size() == 0)
            return true;
        return false;
    }
}