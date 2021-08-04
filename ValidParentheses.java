// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				st.add(')');
			else if (s.charAt(i) == '{')
				st.add('}');
			else if (s.charAt(i) == '[')
				st.add(']');
			else if (st.isEmpty() || s.charAt(i) != st.pop())
				return false;
		}
		return st.isEmpty();
	}
}
