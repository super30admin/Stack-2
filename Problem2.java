class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c==')' || c==']' || c=='}'){
                if(st.isEmpty()) return false;
                int c2 = st.peek();
                if(c==')' && c2 == '('){
                    st.pop();
                }
                else if(c=='}' && c2 == '{'){
                    st.pop();
                }
                else if(c==']' && c2 == '['){
                    st.pop();
                }
                else return false;
            }
            else{
                st.push(c);
            }
        }
        if(!st.isEmpty()) return false ; 

        return true;
    }
}