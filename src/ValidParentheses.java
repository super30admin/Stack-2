// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    Map<Character, Character> map = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};
    Stack<Character> stack = new Stack<>();
    public boolean isValid(String s) {
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
