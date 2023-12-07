// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ValidParantheses {
    class Solution {
        public boolean isValid(String s) {
            int sLen = s.length();
            if(s == null || sLen == 0)
                return true;

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < sLen; i++){
                char c = s.charAt(i);
                if(c == '('){
                    stack.push(')');
                }
                else if(c == '['){
                    stack.push(']');
                }
                else if(c == '{'){
                    stack.push('}');
                }
                else{
                    if(stack.isEmpty() || stack.pop() != c)
                        return false;
                }
            }
            if(!stack.isEmpty())
                return false;
            return true;
        }
    }
}
