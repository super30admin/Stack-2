package codes;

import java.util.HashMap;
import java.util.Stack;

public class Valid_par_solu {
	class Solution {
	    // o(n) spc and tc
	      private HashMap<Character, Character> mappings;
	    public Solution(){
	    this.mappings= new HashMap<Character, Character>();
	    this.mappings.put(')', '(');
	    this.mappings.put('}', '{');
	    this.mappings.put(']', '[');    
	    this.mappings.put(')', '(');
	    this.mappings.put('}', '{');
	    this.mappings.put(']', '[');
	    }
	    public boolean isValid(String s) {
	         Stack<Character> stack = new Stack<Character>();
	        
	        
	        for(char c : s.toCharArray()){
	            
	            if(this.mappings.containsKey(c)){
	                // must be a closing bracket
	                
	                // get last element 
	                
	                
	                char last_element= stack.empty() ? ' ' :stack.pop();
	                
	                
	                if(last_element!=this.mappings.get(c)){
	                    return false;
	                }
	                
	                
	                
	                
	                
	            }
	            else{
	                
	                stack.push(c);
	            }
	            
	            
	        }
	        
	        return stack.isEmpty();
	    }
	}
}
