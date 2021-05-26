//Time Complexity : O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        //use a stack to keep track of open parenthesis
        Stack<Character> stk = new Stack<>();
        //iterate through the string
        for(int i=0;i<s.length();i++){
            //push only if opening is found
            if(s.charAt(i)=='('){
                stk.push(')');
            }
            else if(s.charAt(i)=='['){
                 stk.push(']');
            }
            else if(s.charAt(i)=='{'){
                stk.push('}');
            }
            //if it is an closing bracket at the begining or if teh poped item does not match the current one return false
            else{
                if(stk.empty()||s.charAt(i)!=stk.pop()){
                    return false;
                }
            }
        }
        //at the end of the iteration if there is still some parentheseis left in the stack, the n the string is invalid and it does not contain a proper pair of parenthesis.
        if(!stk.isEmpty()){
            return false;
        }
        return true;
    }
}