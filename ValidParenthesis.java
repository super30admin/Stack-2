/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Idea: Use a stack to match the parenthesis.
 * Space Complexity: O(n)
 * Time Complexity: O(n)
 */
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        Set<Character> set = new HashSet<>();
        set.add('{');
        set.add('(');
        set.add('[');

        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if (set.contains(token)) {
                stack.push(token);
            } else if (!stack.isEmpty() && stack.peek() == map.get(token)) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}