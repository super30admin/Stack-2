// Time Complexity : O(n) where 'n' is the length of the string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/valid-parentheses/
// Any problem you faced while coding this : No


class Solution {
    public boolean isValid(String s) {
     if(s==null||s.length()==0) return true;
      	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();

    }
}
