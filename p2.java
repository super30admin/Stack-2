// Time Complexity :O(n) n is the length of s
// Space Complexity : O(n) n is the length of s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //If it's opening bracket, push it in stack'
            if(c == '(' || c=='{' || c=='['){
                stk.push(c);
            }//If it's closing bracket, check the top of the stack
            else{
                if(stk.isEmpty()) return false;
                char d = stk.pop();
                if(c == ')'  &&  d != '(') return false;
                if(c == '}'  &&  d != '{') return false;
                if(c == ']'  &&  d != '[') return false;
            }
        }

        if(stk.isEmpty()) return true;
        return false;
    }
}