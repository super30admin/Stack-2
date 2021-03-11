//Time Complexity: O(n)
//Space Complexity: o(n)
//Expln: Push opposite braces in the stack and if not opening brace then check the char == st.pop else return false because if not 
//opening braces then we expect the closing brace should already be in stack hence we pop and check else return false because there
//might be  ")}]" stack will be empty here we cannot return true here return false if its empty or doesnt match
// return  true only when stack is empty else false as there might just be openinin braces 
class Solution {
    public boolean isValid(String s) {
        if(s.length() < 2) return false;
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            if(c == '{') st.push('}');
            else if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else
            {
                if(!st.isEmpty() && st.peek() == c)
                {
                    st.pop();
                    continue;
                }
                else return false;
            }
        }
        return st.isEmpty();
    }
}