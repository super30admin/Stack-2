import java.util.Stack;


/**
 Time complexity - o(n)
 Space complexity - o(n)

 Approach.
 start iteraiting through the given string,
 for every opening bracket in the string, push the corresponding closing bracket to the stack.
 if we encounter closing bracket, check if stack is empty,
 IF it is empty return false. because without opening bracket  closing bracket will break the validity.
 If element on top of stack is not the current character, then also return false because it breaks the validity.
 If current character matches the element on top, pop the element.
 once out of forloop, check if stack is empty and return true if its,
 as valid paranthesis doesnt contain extra parenthesis that remains in the stack.

 https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            // current charAt i
            char c = s.charAt(i);
            // for every open bracket push corresponding closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // Stack is empty or element on top is not the current char, retun false
                if (stack.isEmpty() || stack.peek()!=c) {
                    return false;
                }else{
                    // Remove the matching opening bracket from the stack
                    stack.pop();
                }
            }
        }
        //return true if stack is empty
        return stack.isEmpty();
    }
}
