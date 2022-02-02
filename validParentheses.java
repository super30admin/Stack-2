// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a stack to store the opening parantheses and when we encounter a closing parantheses we pop and compare with the top of stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                char out = stack.pop();
                if ((c == ')' && out != '(') || (c == '}' && out != '{') || (c == ']' && out != '[')) {
                    return false;
                }
            }
        }

        return true;
    }
}