/*
 * #20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([)]"
Output: false

Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1. 1 <= s.length <= 104
2. s consists of parentheses only '()[]{}'.

 */


/*
 * Time Complexity: O (N) -> To traverse the characters in input string
 * 
 * Space Complexity: O (N) -> Stack to store 'N' opening parenthesis(bracket)
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.stack2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {
		
		/****************** Hardcoded characters - Stack approach *************/
		// This approach will fail if new characters are introduced in the input string
        
        /*// #1. Create a stack
        Stack<Character> stack = new Stack<Character>();
        
        // #2. Traverse through the string to check if it is valid or not
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            // If opening bracket, push to the stack
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            // If closing brackets, check for the corresponding opening bracket at top of stack and pop, if not correct opening bracket, return false directly 
            else if(!stack.isEmpty()){
                // If closing brackets
                
                    if(ch == ')' && stack.pop() != '('){
                        return false;
                    }
                    else if(ch == ']' && stack.pop() != '['){
                        return false;
                    }
                    else if(ch == '}' && stack.pop() != '{'){
                        return false;
                    }
                    
            }
            // handles case : e.g. - s = "]", In this case, if and else if will not be executed
            else{
                return false;
            }
            
        }
        
        // After traversing all characters in a string, if stack is empty, means string is valid
        return stack.isEmpty(); */
		
		/***************** Generic code to handle any character - Stack approach *****************/
		
		// #1. Create a hashset for opening brackets
        HashSet<Character> opening = new HashSet<Character>(Arrays.asList('{', '[', '('));
        
        // #2. Create a HashMap to store the closing brackets as key and corresponding opening brackets as value
        HashMap<Character, Character> closing = new HashMap<>() {{
            put('}', '{'); 
            put(']', '['); 
            put(')', '(');
            }};
        
        // #3. Create a stack to check the given two conditions, when correct ordering is asked, use stack
        Stack<Character> stack = new Stack<Character>();
        
        // #4. Traverse through the string to check if it is valid or not
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            // If opening bracket, push to the stack
            if(opening.contains(ch)){
                stack.push(ch);
            }
            // If closing brackets, check for the corresponding opening bracket at top of stack and pop, if not correct opening bracket, return false directly 
            else if(!stack.isEmpty()){
                // If closing brackets
                if(closing.get(ch) != stack.pop()){
                    return false;
                }
                    
            }
            // handles case : e.g. - s = "]", In this case, if and else if will not be executed
            else{
                return false;
            }
            
        }
        
        // After traversing all characters in a string, if stack is empty, means string is valid
        return stack.isEmpty(); 
        
    }

}
