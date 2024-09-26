package validParan;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
        if(s.length() == 0 || s == null)
        {
            return true;
        }
        
    Stack<Character> stack = new Stack<>();
        
     for(int i=0; i<s.length(); i++)
      {
           char c = s.charAt(i);
            
                if(c == '(')
                 {
                    stack.push(')');
                 }
            
                else if(c == '{')
                 {
                	stack.push('}');
                 }
            
                else if(c == '[')
                {
                	stack.push(']');
                }
            
                else if (stack.isEmpty() || stack.pop() != c)
                {
                	return false;
                }
     }
   if(!stack.isEmpty())
     {
        return false;
     }
        return true;
}

public static void main(String[] args) {
		String s = "({})";
		Solution obj = new Solution();
		System.out.println(obj.isValid(s));
	
	}

}
