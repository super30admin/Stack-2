//Time complexity and Space complexity : 0(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stack.push(')');
            else if(c=='{') stack.push('}');
             else if(c=='[') stack.push(']');
            //for only "]"
            else if(stack.isEmpty() || stack.pop()!=c) return false;   
        }
        // for only "["
        return stack.isEmpty();
        
    }
}