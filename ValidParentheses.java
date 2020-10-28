// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using Stack
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++ ){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[' ){
                stack.push(c);
            }else if(c==')' && !stack.isEmpty() && stack.peek()=='(' ){
                stack.pop();
            }else if(c=='}' && !stack.isEmpty() && stack.peek()=='{'  ){
                stack.pop();
            }else if(c==']' && !stack.isEmpty() && stack.peek()=='['  ){
                stack.pop();
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
        
    }
}
