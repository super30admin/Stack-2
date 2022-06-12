/*
 * TC = O(N)
 * SC = O(N)
 * 
 * Whenever we come across opening bracket of any sort, we push into the stack
 * Whenever we come across a closing bracket of any sort, we check the top of the stack
 * and return the answer accordingly.
 */
import java.util.*;
public class ValidParanthesis {
    
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0 ) return true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i =0;i<s.length();i++)
        {
            char curr = s.charAt(i);
            
            if(curr == '(' || curr == '{' || curr == '[')
            {
                stack.push(curr);
            }
            else
            {
                if(stack.isEmpty()) return false;
                if(curr == ']' && stack.peek()!='[') return false;
                if(curr == ')' && stack.peek()!='(') return false;
                if(curr == '}' && stack.peek()!='{') return false;
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    public static void main(String args[])
    {
        System.out.println(isValid("()"));
    }
}
