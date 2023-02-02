import java.util.Stack;

// Time O(N)
// Space O(N)

public class ValidParentheses {
	public boolean isValid(String s) {
	       Stack<Character> stack = new Stack<>();
	       for(char ch:s.toCharArray()){
	           if(ch=='}'){
	               if(stack.isEmpty() || stack.peek()!='{')
	                    return false; 
	               else 
	                    stack.pop();       
	           }else if(ch==')'){
	                if(stack.isEmpty() ||stack.peek()!='(')
	                    return false; 
	                else 
	                    stack.pop(); 
	           }else if(ch==']'){
	                 if(stack.isEmpty() ||stack.peek()!='[')
	                    return false; 
	                else 
	                    stack.pop(); 
	           }
	           else{
	               stack.push(ch);
	           }
	       } 
	       return stack.isEmpty();
	    }
}
