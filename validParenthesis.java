// Time complexity : O(n)
// Space Complexity : O(n) 
// Works on leetcode


class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }
            else if (ch == '['){
                stack.push(']');
            }
            else if (ch == '{'){
                stack.push('}');
            }
            else{
                if(stack.isEmpty() || ch != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
