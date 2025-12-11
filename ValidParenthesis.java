// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a stack and push each opening brace into it as the closing brace. While parsing, if we come across a closing
// brace that is at the top of stack, we continue. IF the condition fails, we return false. We use stack here because, we are concerned about
// find the closing brace for last incoming brace.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(')'); //push the corresponding closing brace
            } else if(ch == '['){
                st.push(']'); //push the corresponding closing brace
            } else if(ch == '{'){
                st.push('}'); //push the corresponding closing brace
            } else if(st.isEmpty() || ch != st.pop()){ //if top of stack doesn't equal to closing brace
                return false;
            }
        }
        return st.isEmpty();
    }
}