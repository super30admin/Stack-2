// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(!stk.isEmpty() && stk.peek()=='('){
                    stk.pop();
                    continue;}
                else
                    return false;}
            else if(c == ']'){
                if(!stk.isEmpty() && stk.peek()=='['){
                    stk.pop();
                    continue;}
                else
                    return false;}
            else if(c == '}'){
                if(!stk.isEmpty() && stk.peek()=='{'){
                    stk.pop();
                    continue;}
                else
                    return false;}
            stk.push(c);
        }
        return stk.isEmpty();
    }
}