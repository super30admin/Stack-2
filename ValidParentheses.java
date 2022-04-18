import java.util.Stack;

/*
Time complexity: O(N), N is the length of String
Space Complexity: O(N), I am using stack
Run on Leetcode: yes
Any difficulties: no

Approach:
1. Taking Character stack and will keep adding open parentheses in that, when ever I will encounter closing parentheses
I am gonna pop out it's another pair from the stack if that is present there
2. At the end I am gonna return if stack is empty or not
 */
public class ValidParentheses {
    public static boolean isValidParenthese(String s){
        if(s.length()%2!= 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' &&!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }
            else if(c == '}' &&!stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }
            else if(c == ']' &&!stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println("Valid Parenthese: "+ isValidParenthese("()"));
        System.out.println("Valid Parenthese: "+ isValidParenthese("()[]{}"));
        System.out.println("Valid Parenthese: "+ isValidParenthese("(]"));
    }
}
