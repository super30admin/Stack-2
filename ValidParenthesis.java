// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
      
      Stack<Character> stack = new Stack<>();
      
      for(int i=0;i<s.length();i++)
      {
        char ch = s.charAt(i);
        if(ch=='[')
        {
          stack.push(']');
        }
        else if(ch=='{')
        {
          stack.push('}');
        }
        else if(ch=='(')
        {
          stack.push(')');
        }
        else
        {
          if(stack.isEmpty() || stack.peek() != ch)
          {
            return false;
          }
          stack.pop();
        }
      }
        return stack.isEmpty();
    }
}