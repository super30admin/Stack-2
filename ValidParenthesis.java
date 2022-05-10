//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            System.out.print(c);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty()){
                if(stack.peek() == '(') stack.pop();
                else return false;
            }else if(c == '}' && !stack.isEmpty()){
                if(stack.peek() == '{') stack.pop();
                else return false;
            }else if(c == ']' && !stack.isEmpty()){
                if(stack.peek() == '[') stack.pop();
                else return false;
            }else if((c == ')' || c == '}' || c == ']') && stack.isEmpty()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
