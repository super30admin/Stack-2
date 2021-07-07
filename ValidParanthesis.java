// 20.
// stack - most recently opened bracket has to be closed first - similar to lifo
// approach - for each opening bracket, push its corresponding closing bracket into stack -> if a closing bracket is seen, pop from stack and check both are equal, if not return false -> at the end return true if stack is empty
//time - O(n)
//space - O(n)

class Solution {
    public boolean isValid(String s) {
        //edge
        if(s == null || s.length() == 0)
        {
            return true;
        }
        
        Stack<Character> support = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(current == '(')
            {
                support.push(')');
            }
            else if(current == '{')
            {
                support.push('}');
            }
            else if(current == '[')
            {
                support.push(']');
            }
            else //all othe chars are some closing bracket
            {
                if(support.isEmpty() || support.pop() != current)
                {
                    return false;
                }
            }
        }
        
        return (support.size() == 0);
    }
}
