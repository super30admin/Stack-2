// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
class ValidParentheses {
    Stack<Character> st;
    public boolean isValid(String s) {
        st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
              st.push(')');
            }
            if(c=='{'){
              st.push('}');
            }
            if(c=='['){
              st.push(']');
            }
           
           if(!st.isEmpty() && (c==')' || c=='}' || c==']')){
                char popped = st.pop();
                if(popped!=c){
                  return false;
                }                
            }
            else if(st.isEmpty() && c==')' || c=='}' || c==']')
              return false;

        }
        return st.isEmpty();
    }
}