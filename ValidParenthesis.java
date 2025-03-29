import java.util.Stack;

// TC: O(n) in both the approaches, all the characters are visited.
// SC: O(n) as stack is used

// Runs successfully on leetcode.
// In both the approaches, either opening or closing bracket is pushed. 
// and other bracket is checked if it matches when stack is not empty.
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid1stApproach("()")); // true
        System.out.println(isValid1stApproach("()[]{}")); // true
        System.out.println(isValid1stApproach("(]")); // false
        System.out.println(isValid1stApproach("([])")); // true

        System.out.println(isValid2ndApproach("()")); // true
        System.out.println(isValid2ndApproach("()[]{}")); // true
        System.out.println(isValid2ndApproach("(]")); // false
        System.out.println(isValid2ndApproach("([])")); // true
    }

    public static boolean isValid1stApproach(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() &&
                    c == ')' && stack.peek() == '(' ||
                    c == ']' && stack.peek() == '[' ||
                    c == '}' && stack.peek() == '{') {
                stack.pop();
            } else
                return false;
        }
        return true;
    }

    public static boolean isValid2ndApproach(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
