// Time complexity: O(n) where n is the length of the string
// Space complexity: O(n) worst case if string contains all opening brackets

// Approach - we use a stack to find inner most bracket pair. We usually use a stack when we need to get the most recent element (top most element of stack). Here, we push to the stack whenever we find opening brackets. When we get a closing bracket, we need to compare it with the top of the stack. If they are not equal then it is invalid

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '{' || currChar == '(' || currChar == '[') {
                stack.push(currChar);
            } else {
                if (stack.isEmpty() || map.get(currChar) != stack.pop()) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}