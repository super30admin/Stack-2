import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        //Time complexity: O(N)
        //Space complexity: O(N)
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }
            else if(stack.isEmpty())return false;

            else if(ch == ')'){
                if(stack.peek() == '(')stack.pop();
                else return false;
            }
            else if(ch == '}'){
                if(stack.peek() == '{') stack.pop();
                else return false;

            }
            else if(ch ==']'){
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();

    }
}
