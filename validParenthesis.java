// Time Complexity : O(n) where n is the length of the string s
// Space Complexity : O(n) where n is the length of the string s
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class validParenthesis {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = !stack.isEmpty() ? stack.peek() : '#';
                if (map.getOrDefault(top, '#') != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}