//o(n) time and space
//passed ll leetcode cases
//used stack approach

class Solution {
    public boolean isValid(String s) {
        if(s==null ||s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(')');
            if(ch == '{') stack.push('}');
            if(ch == '[') stack.push(']');
            if(ch==')' || ch=='}' || ch==']'){
                if(stack.isEmpty()) return false;
                if(ch!=stack.pop()) return false;
            }

        }
        return stack.isEmpty();
    }
}