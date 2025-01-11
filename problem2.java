import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)

public class problem2 {

public boolean isValid(String s)
{
    Stack<Character> st = new Stack<>();
    int n =s.length();

    for (int i = 0; i < n; i++)
    {
        char c = s.charAt(i);
        if (c=='(')
        {
            st.push(')');
        }
        else if (c=='{')
        {
            st.push('}');
        }
        else if (c=='[')
        {
            st.push(']');
        }
        else if (st.isEmpty() || c!=st.pop())
        {
            return false;
        }
    }
    return st.isEmpty();
}

}
