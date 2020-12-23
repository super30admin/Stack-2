import java.util.Stack;

public class ValidParanthesis {
	public boolean isValid(String s) {

		Stack<Character> str = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);

			if (ch == '(') {
				str.push(')');
			} else if (ch == '{') {
				str.push('}');
			} else if (ch == '[') {
				str.push(']');
			} else if (str.isEmpty() || str.pop() != ch) {
				return false;
			}

		}

		if (!str.isEmpty())
			return false;

		return true;

	}
}
