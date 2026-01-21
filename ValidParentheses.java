import java.util.Stack;
class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            if('(' == s.charAt(i))
            {
                stack.push(')');
            }
            else if('[' == s.charAt(i))
            {
                stack.push(']');
            }
            else if('{' == s.charAt(i))
            {
                stack.push('}');
            }
            else
            {
                if(stack.isEmpty() || stack.pop() != s.charAt(i))
                {
                    return false;
                }
            }
        }

        if(!stack.isEmpty())
        {
            return false;
        }
        return true;
    }
}