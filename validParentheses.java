import java.util.*;
// TC: O(n) for the traversing string
// SC: O(n) for stack

public class validParentheses {

	public boolean checkvalidity(String s) {
		
		Stack<Character> st = new Stack<>();
		char c = ' ';
		for(int i=0;i<s.length();i++) {
			
			
			// if there is an opening bracket, push the closing bracket onto stack
			if(s.charAt(i) == '(') {
				st.push(')');
			}else if(s.charAt(i) == '{') {
				st.push('}');
			}else if(s.charAt(i) == '[')
				st.push(']');
			else {
			
				
				// if the stack is empty, we know that we have encountered opening and closing bracket, we can remove from the stack
				if(!st.isEmpty()) {
					c = st.pop();
				}
				
				// we need to check if the removed character is same as top element from the stack, we should return false since
				// we know that the stack does not have closing bracket
				if(st.peek() != c){
					return false;
				}
			}
		}
		
		// if the stack is empty, we have encountered both opening and closing bracket since we would popped element from the stack
		// we can return true
		if(st.isEmpty())
			return true;
		// if the stack is not empty, we have more closing bracket or more opening bracket, we need to return false
		return false;
	}
}
