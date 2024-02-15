/* Time Complexity : O(n)
 *   n - length of String - s  */
/* Space Complexity : O(n) 
 * stack size */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*While iterating over the string, if we encounter an open bracket, push it's sorrespondinf closing bracket to stack.
if we encounter a closing bracket, pop from stack and  check if it is same else return false*/

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(')');
            } else if(ch == '{'){
                st.push('}');
            } else if(ch == '['){
                st.push(']');
            } else if(st.isEmpty() || st.pop() != ch){
                return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}