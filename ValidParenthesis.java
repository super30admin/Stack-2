// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        // return false if input string is empty or length of string is not even
        // since a valid string will always have pais of parenthesis
        if(s == null || s.length() == 0 || s.length() % 2 != 0) return false;
        // convert the string to character array
        char[] braceArray = s.toCharArray();
        Stack<Character> st = new Stack<>();
        // iterate through the character array
        for(char brace : braceArray){
            // keep pushing the openeing parenthesis inside the stack
            if(brace == '(' || brace == '{' || brace == '[') st.push(brace);
            // in case of closing parenthesis, also check for corresponding opening parentheses
            // at the top of the stack
            // if found, then pop the element from the stack
            else if (brace == ')' && !st.isEmpty() && st.peek() == '(') st.pop();
            else if(brace == '}' && !st.isEmpty() && st.peek() == '{') st.pop();
            else if(brace == ']' && !st.isEmpty() && st.peek() == '[') st.pop();
            // return false in case corresponding opening parenthesis is not found
            else return false;
        }
        // at the end, check for an empty stack and return
        return st.isEmpty();
    }
}