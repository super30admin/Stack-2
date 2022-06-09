class Solution {

    // Time Complexity : 0(n) where n is the length of the string
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> st = new Stack<>();    //we take a stack because we need to store the order of input of brackets
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);   //extracting 1 character at a time
            if(c == '{'){   //we store the closing bracket when we encounter an opening bracket as it will be easy to check while popping
                st.push('}');
            }
            else if(c == '['){
                st.push(']');
            }
            else if(c == '('){
                st.push(')');
            }
            else if(st.isEmpty() || c != st.pop()){ //if it is not an opening bracket, then it must be a closing bracket. So the last bracket that is openend in our string must be the 1st to close so we check the character with the top of the stack. If it's not same we return false
                return false;   //also we are putting a condition for stack is empty because if we are given only single bracket, then there will be nothing in our stack and we will get a wrong output
            }

        }
        return st.isEmpty();    //if the stack is not empty means the order of parenthesis is not correct or all the brackets are not closed or accounted for hence it will return false. If stack is empty means all of the brackets are accounted for in correct order.
    }
}