//time o(n)
//space o(1)
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() ==0)
            return true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i< s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                stack.push(')');
            }
            else if(ch == '{') {
                stack.push('}');
            }
            else if(ch == '[') {
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || ch != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}