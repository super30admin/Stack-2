// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        //base case
        if(s == null || s.length() == 0)
            return true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(ch == '(') stack.push(')');
            if(ch == '[') stack.push(']');
            if(ch == '{') stack.push('}');
            
            if(ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty()) return false;
                if(ch != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
