
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


import java.util.*;

public class ValidParentheses {

	public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch == '(')
				stack.push(')');
			else if(ch == '[')
				stack.push(']');
			else if(ch == '{')
				stack.push('}');
			
			if(ch == ')' || ch == '}' || ch == ']') {
				if(!stack.isEmpty()) {
					if(stack.pop() != ch) {
						return false;
					}
				}
			}
		}
		
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		
		ValidParentheses v = new ValidParentheses();
		boolean res = v.isValid("(()()");

		System.out.println(res);

	}

}
