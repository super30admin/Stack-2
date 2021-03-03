// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(c == '}'){
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                }
                else if(c == ']'){
                    if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                }
                else if(c == ')'){
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}