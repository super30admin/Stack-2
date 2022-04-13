// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will maintain a stack and when we see a opening bracket
// we will push it to stack. When we see a closing bracket
// we will check if the top of stack is respective opening or not
// If not we will return false, otherwise we will continue
// At the end if stack is empty that means matching is fulfilled and we return true.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else{
                if(st.isEmpty())
                    return false;
                if((c == ')' && st.peek() == '(') || (c == ']' && st.peek() == '[') || (c == '}' && st.peek() == '{')){
                   st.pop(); 
                }
                else
                    return false;
            }
        }
        if(st.isEmpty())
            return true;
        return false;
    }
}