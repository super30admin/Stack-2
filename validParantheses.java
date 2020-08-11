// Time Complexity : - where n is the length of the input string.
// Space Complexity : O(n) - where n is the length of the input string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: The approach is to push the respective closing bracket into the stack for each opening bracket. Whenever a closing bracket is encountered and it is not on top of the stack, we return false. At the end if the stack is not empty also we return false.

class Solution {
    public boolean isValid(String s) {
       if(s==null || s.length()==0) return true;
       Stack<Character> st=new Stack<>();
       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(c=='(') st.push(')');
           else if(c=='[') st.push(']');
           else if(c=='{') st.push('}'); 
           else{
               if(st.isEmpty() || c!=st.pop()) return false;
              }
       }
      return st.isEmpty();
        
    }
}