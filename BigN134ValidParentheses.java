//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

import java.util.Stack;

public class BigN134ValidParentheses {
	class Solution {
		public boolean isValid(String s) {
			// edge case
			if (s == null || s.length() == 0)
				return true;
			if (s.length() % 2 != 0)
				return false;
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(')
					st.push(')');
				else if (c == '{')
					st.push('}');
				else if (c == '[')
					st.push(']');
				else if (st.isEmpty() || c != st.pop())
					return false;
			}
			if (!st.isEmpty())
				return false;
			return true;
		}
	}
}