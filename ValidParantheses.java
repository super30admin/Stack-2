// Time complexity = O(n)// iterating over every character.
// Space complexity = O(n)// stack.
// if it were just one type of brackets such as () or {} or [], then use counter. 
// do not use stack. get rid of that extra space.
// since we have different types of brackets, so we use stack.
// it maintains order as well. 
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i< s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='(') {
                stack.push(')');
            }
            else if(ch=='[') {
                stack.push(']');
            }
            else if(ch=='{') {
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=ch) {
                return false;
            }
            
        }
        return stack.isEmpty();
    }
}