// Time Complexity : O(N), single iteration
// Space Complexity : O(N), used stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//use stack to store the closing brackt for every opening bracket
//for every closing bracket, check if the stack is empty or not. If yes, then push the element onto the stack. 
//If NO, check if the peek element of stack is equal to current closing bracket, if not then return false. 
//If stack is not empty and character matches with peek, then pop the element from the stack.

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> S = new Stack<>();
        
        char[] ch = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            if(ch[i] == '('){
                S.push(')');
            }else if(ch[i] == '{'){
                S.push('}');
            }else if(ch[i] == '['){
                S.push(']');
            }else{
                if(!S.isEmpty()){
                    if(ch[i] != S.peek()){
                    return false;
                }
                     S.pop();
                }else{
                    S.push(ch[i]);
                }
               
            }            
            
        }
        return S.isEmpty();
    }
}