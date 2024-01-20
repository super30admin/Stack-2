// Time Complexity :  O(N)
// Space Complexity : O(N/2)
// Did this code successfully run on Leetcode :Yes

import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String s) {

      Stack<Character> stack = new Stack<Character>();

      for(int i =0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='{'){
          stack.push('}');
        }
        else  if(c=='['){
          stack.push(']');
        }
        else  if(c=='('){
          stack.push(')');
        }
        else if (!stack.isEmpty() && c == stack.peek()){
          stack.pop();
        }
        else return false;
      }

      if(!stack.isEmpty()) return false;
      return true;

    }
  }
