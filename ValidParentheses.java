/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public boolean isValid(String s) 
    {
        Stack<Character> stack = new Stack<>();
        
        for( int i=0; i< s.length(); i++)
        {
            char current = s.charAt(i);
            
            switch(current)
            {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if(stack.isEmpty())
                        return false;
                    else
                    {
                        char top = stack.pop();
                        if( top != current)
                            return false;
                    }                                                                            
            }
        }
        
        return stack.isEmpty();
    }
}