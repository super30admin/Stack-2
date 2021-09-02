//Time Complexity : O(n), n -> Length of given string
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem2;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		if (s.length() % 2 == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');
			} else if (ch == '[') {
				stack.push(']');
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				if (ch == stack.peek()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses obj = new ValidParentheses();
		String parentheses = "({}){[{()[]}]}";

		System.out.println("Is the given parentheses valid? " + (obj.isValid(parentheses) ? "Yes" : "No"));
	}

}
