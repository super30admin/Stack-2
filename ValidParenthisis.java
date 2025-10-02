// This solution uses a stack based approach to store the inverse of a given character whenever an element is encoutered. I.e,, } for { and ) for (
// Similarly for closing characters we check from the top of stack if its same if not its breach
// At the end if at all stack is empty that means all the braces have associated closings in right order
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c:s.toCharArray()) {
            if(c=='(') {
                stack.push(')');
            } else if(c=='[') {
                stack.push(']');
            } else if(c=='{') {
                stack.push('}');
            } else {
                if(stack.isEmpty()) return false;
                if(stack.pop()!=c) return false;
            }
        }
        return stack.isEmpty();
    }
}
