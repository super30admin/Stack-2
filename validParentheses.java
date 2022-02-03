// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a stack to store the closing parantheses when we encounter an opening parantheses and
// we pop and compare with the top of stack in case of opening parantheses
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c:s.toCharArray()) {
            if (c=='(')
                stack.push(')');
            else if (c=='[')
                stack.push(']');
            else if (c=='{')
                stack.push('}');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}