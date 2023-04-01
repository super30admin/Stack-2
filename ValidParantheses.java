import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Maintain a mapping for closing parantheses to open perantheses. If the
 * current character is present in map, then get the peek element from stack if
 * not empty. compare value of current char from the map with the top element.
 * If not equal or stack is empty, return false. Else if it is not a key in map,
 * push to stack. Finally return if stack is empty or not. If empty, its true
 * else false.
 *
 */
class Solution {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				char top = !stack.isEmpty() ? stack.pop() : '#';
				if (top != map.get(c))
					return false;
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
