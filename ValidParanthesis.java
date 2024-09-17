//TimeCOMPLEXITYL O(N)
//SpaceCOMPLEXITYL O(N)
class Solution {
   public static boolean isValid(String s) {
            char[] str = s.toCharArray();
	Stack<Character> stack = new Stack<Character>();
	char check;
	for (char c: str) {
		if (c == '{' || c == '[' || c == '(') {
			stack.push(c);
		} else {
			if (!stack.isEmpty()) {
				check = stack.pop();
				if (c == '}' && check != '{') {
					return false;
				} else if (c == ']' && check != '[') {
					return false;
				} else if (c == ')' && check != '(') {
					return false;
				}
			} else {
			    return false;
			}
		}
	}
	
	if (!stack.isEmpty()) {
		return false;
	}
	
            return true;
}
}
