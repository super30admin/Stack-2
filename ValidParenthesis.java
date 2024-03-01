import java.util.Stack;

public class ValidParenthesis {
    //TC= O(N)
    //SC=O(1)

        public boolean isValid(String s) {
            Stack<Character> stack= new Stack<>();
            char[] str= s.toCharArray();
            for(int i=0; i<str.length;i++ ){
                if(str[i]=='('){
                    stack.push(')');
                }
                else if(str[i]=='{'){
                    stack.push('}');
                }
                else if(str[i]=='['){
                    stack.push(']');
                }

                else if(stack.isEmpty() || stack.pop() != str[i]) {
                    return false;
                }
            }
            return stack.isEmpty();

        }
    }

