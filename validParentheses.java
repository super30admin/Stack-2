class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length()%2 != 0)return false;

        for(int i =0 ;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '[')
                st.push(']');
            else if(ch == '{')
                st.push('}');
            else if(ch == '(')
                st.push(')');    
            else{
                if(st.isEmpty())
                    return false;
                else if(st.pop() != ch)
                    return false;
            }
        }
    return st.size() == 0 ? true : false;
        
    }
}