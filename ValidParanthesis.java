//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char c : charArr)
        {
            if(c == '('){
                st.push(')');
            } else if (c == '['){
                st.push(']');
            } else if (c == '{'){
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c){
                return false;
            }
        }
        return st.isEmpty();
    }
}