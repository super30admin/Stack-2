package stacks2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
	//Time Complexity : O(n), where n is length of string s
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(!map.containsKey(c))
                stack.push(c);
            else if(stack.isEmpty() || stack.pop() != map.get(c))
                return false;
        }
        
        return stack.isEmpty();
    }
	
	//Time Complexity : O(n), where n is length of string s
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '[')
                stack.push(']');
            else if(c == '{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        
        return stack.isEmpty();
    }
}
