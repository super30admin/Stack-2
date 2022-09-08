// TC=o(n)
// SC=o(n)


class Solution {
    public boolean isValid(String s) {
       
        Stack<Character> st = new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='(') st.push(')');
            else if(c=='{') st.push('}');
            else if(c=='[') st.push(']');
            else if(st.isEmpty() || st.peek()!=c) return false;
            else st.pop();
        }
        return st.isEmpty();
    }
}

