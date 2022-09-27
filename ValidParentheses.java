import java.util.Stack;

// Time Complexity : O(n) where n = length of string
// Space Complexity : O(n) where n = length of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//20. Valid Parentheses (Easy) - https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>(); // O(n)
        
        for (int i = 0; i < s.length(); i++) { // O(n)
            char ch = s.charAt(i);
            
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            else if (stack.isEmpty() || ch != stack.pop()) return false;
        }
        
        return stack.isEmpty();
    }
}