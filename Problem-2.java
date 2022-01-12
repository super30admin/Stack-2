// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        
        for(int i=0;i<s.length();i++)
        {
            char temp = s.charAt(i);
            if(temp == '{' || temp == '[' || temp == '(')
            {
                stack.push(temp);
                continue;
            }
            if(stack.isEmpty())
            {
                return false;
            }
            char temp2;
            
            switch(temp)
            {
                case ')':
                {
                    temp2 = stack.pop();
                    if(temp2 != '(')
                        return false;

                    break;
                }
                case ']':
                {
                    temp2 = stack.pop();
                    if(temp2 != '[')
                        return false;

                    break;
                }
                case '}':
                {
                    temp2 = stack.pop();
                    if(temp2 != '{')
                        return false;
                    
                    break;
                }
            }
            
        }
        
        return(stack.isEmpty());
    }
}