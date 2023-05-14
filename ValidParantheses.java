/*
Time Complexity - O(N)
Space Complexity - O(N)
 */
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(')');
            else if(s.charAt(i) == '[')
                stack.push(']');
            else if(s.charAt(i) == '{')
                stack.push('}');
            else if(stack.isEmpty() || s.charAt(i) != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }
}
