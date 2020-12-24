// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nopes

/*class Solution {
    public boolean isValid(String s)
    {
        if(s==null ||s.length()==1)
            return false;

        Stack<Character> stack = new Stack();



        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='[')
            {
                stack.push(ch);
            }
            else if(stack.isEmpty() && (ch ==')' || ch =='}' || ch ==']'))
            {
                return false;
            }
            else
            {
                char top = stack.pop();

                if(ch ==')' && top != '(')
                {
                    return false;
                }
                else if(ch =='}' && top != '{')
                {
                    return false;
                }
                else if(ch ==']' && top != '[')
                {
                    return false;
                }
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}*/

class SolutionOne {
    public boolean isValid(String s)
    {
        if(s==null ||s.length()==1)
            return false;

        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch=='(')
            {
                stack.push(')');
            }
            else if(ch=='{')
            {
                stack.push('}');
            }
            else if(ch=='[')
            {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop()!=ch)
            {
                return false;
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}
