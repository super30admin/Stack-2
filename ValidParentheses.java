// Time Complexity : O(n) where n is the length of string
// Space Complexity : O(n) as we are using explicit stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to check is stack is empty

/*
Approach: Use stack to store the closing bracket for every equivalent opening bracket. On encountering closing bracket check is stack is empty or doesn't match with the peek element of stack return false else pop in case a matching character is found.Lastly, check if stack is not empty return false else return true.
 */
class Solution {
    public boolean isValid(String s) {

        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                st.push(')');
            }
            else if(c == '{'){
                st.push('}');
            }
            else if(c == '['){
                st.push(']');
            }
            else{
                //In case string is ")"
                if(st.isEmpty() || (st.peek() != c)){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }

        //In case string is "()("
        return st.isEmpty() ? true : false;
    }
}