// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class Validparenthesis {
	 public boolean isValid(String s) {
	        Stack<Character> stack=new Stack<>();
	        
	        for(int i=0;i<s.length();i++){
	            char c=s.charAt(i);
	            if(c=='(' || c=='[' || c=='{'){
	                stack.push(c);
	            }else if(c=='}' && (stack.isEmpty() || stack.pop()!='{')){
	                return false;
	            }else if(c==']' &&  (stack.isEmpty() || stack.pop()!='[')){
	                return false;
	            }else if(c==')' &&  (stack.isEmpty() ||  stack.pop()!='(')){
	                return false;
	            }
	        }
	        
	        return stack.isEmpty();
	  }
}
