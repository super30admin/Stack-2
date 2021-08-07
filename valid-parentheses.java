// Time Complexity : O(n)
// Space Complexity : (n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if( c  == '(')
                stk.push(')');
            else if( c  == '[')
                stk.push(']');
            else if( c  == '{')
                stk.push('}');
            else {
                if(stk.isEmpty()) return false;
                if(stk.peek() != c) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}