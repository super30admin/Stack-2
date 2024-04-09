
import java.util.Stack;
//TC - O(n)
//SC - O(n)
//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(')
                stack.push(')');
            else if(ch=='[')
                stack.push(']');
            else if(ch=='{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop()!=ch)
                    return false; 
        }
        return stack.isEmpty()?true:false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
3 cases
1. open bracket - push inside the stack
2. close bracket - return false if stack is empty or stack.pop is not matching
3. when you have only open brackets, stack will not be empty at the end. return false  */