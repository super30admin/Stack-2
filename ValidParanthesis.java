/*
* Approach: The idea is to keep pushing the opening brackets in the stack and whenever we encounter a closing bracket, 
    - to make it valid paranthesis, we need to make sure the opening bracket is on top fo the stack, if not then its not valid paranthesis
    - TC: O(n) -> n is the length of the string
    - SC: O(n) -> stack space to store characters
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='(' || c =='[' || c =='{'){
                stack.push(c);
            }
            else if(stack.isEmpty())
                return false;
            else if(c == ')'){
                if(stack.pop() != '(')
                    return false;
            }
            else if(c == ']'){
                if(stack.pop() != '[')
                    return false;
            }
            else if(c == '}'){
                if(stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}