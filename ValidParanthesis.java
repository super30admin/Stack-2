/*
https://leetcode.com/problems/valid-parentheses/
Executed on leetcode

time complexity :O(n) -- proces all the expression
Space complexity :O(n)  -- stack space used
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i< s.length() ;i++){
            char c = s.charAt(i);
            if(c== '('){
                st.push(')');
            }
            else if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else{
               if(st.isEmpty() || c!=st.pop()){
                  return false; 
               }
            }
        }
        return st.isEmpty();
    }
}

/*

follow up if given ((())) then for every ( keep counter+ =1 and every ) keep counter -=1 
if sum of counter is negative invalid parentthesis else valid parenthesis 

*/
