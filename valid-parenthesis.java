//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //When we encounter an opening bracking, push the corresponding closing 
            //bracket to the stack
            if(ch == '(') {
                stack.push(')');
            }
            else if(ch == '{') {
                stack.push('}');
            }
            else if(ch == '[') {
                stack.push(']');
            }
            //if the stack is empty (and still we have brackets to process)
            //or if the top element does not matches the incoming element
            else if(stack.isEmpty() || stack.peek() != ch) {
                return false;
            }
            else if (stack.peek() == ch)  {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}