import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
	/* Here, whenever any kind of opening parentheses is encountered, its respective closing parentheses will be pushed inside the stack.
	 * If the character is not the top element of the stack then the string is contains invalid parentheses and returned false.
	 * And after the entire string has been traversed and still the stack is not empty the result will be returned as false.
	 * Else it is a valid string of correct parentheses.
	 */
public class ValidParantheses {
	public boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else if(st.isEmpty() || c != st.pop()) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
