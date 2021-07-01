/*Approach: 
1. Use a stack to store all the opening brackets. If closing bracket comes, match it with the top element in stack
2. If there is nothing in stack and we see a closing bracket, return false
3. If by the end, there are still elements in the stack, return false

Time Complexity: O(N)
Space complexity: Worst case:   O(N)
*/

import java.util.*;
class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for(int i=0; i<= s.length()-1; i++)
        {
            c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[')
                stack.push(c);
            else
            {
                if(stack.isEmpty() || (c == '}' && stack.pop() != '{') || (c == ']' && stack.pop() != '[') || (c == ')' && stack.pop() != '('))
                    return false;
            }
        }
        
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}