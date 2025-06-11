// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

/*Approach:
1. Traverse the input string
2. for each opening bracket push the corresponding closing bracket to the stack
3. for each closing bracket match with the stack top, if doesn't match return false
*/

class Solution {
    public boolean isValid(String s) {

        int n=s.length();
        Stack<Character> st= new Stack<>();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(c=='('){
                st.push(')');
            }
            else if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(st.isEmpty()||c!=st.pop()){  //check for the closing brackets

                return false;
            }
        }

        return st.isEmpty(); //at last if stack is empty it means valid paranthesis
    }
}
