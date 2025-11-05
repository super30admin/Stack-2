// Time Complexity : O(n) where n is the number of chars in string
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using a hashmap to match closing bracket to its matching opening bracket. Pushing the opening bracket in the stack and popping if the matching closing bracket was found.
 * If not, return false since it was not a match.
 * At the end, if there were any chars left in stack, we didn't have all matching brackets.
 */

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // closing bracket
            if (brackets.containsKey(c)) {
                // closing bracket without opening bracket
                // Or the closing bracket type is not same as opening bracket
                if (stack.isEmpty() || brackets.get(c) != stack.pop())
                    return false;
            }
            // opening bracket
            else
                stack.push(c);
        }

        // elements in stack means all brackets didn't match
        return stack.isEmpty();
    }
}