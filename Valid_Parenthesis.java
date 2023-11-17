//TC:o(n)
//SC:o(n)

import java.util.Stack;
public class ValidParenthesis {
    public boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length;i++){
            char bracket = s.charAt(i);
            if(bracket == '{'){
                stack.push('}');
            }
            else if(bracket == '['){
                stack.push(']');
            }
            else if(bracket == '('){
                stack.push(')');
            }
            else if(stack.isEmpty() || stack.peek()!=bracket) return false;
            else if (stack.peek()==bracket) stack.pop();
        }
        return stack.isEmpty();
    }
}