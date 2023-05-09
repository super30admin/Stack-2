//Time -> O(n)
//Space -> O(n)

class Problem2 {
    public boolean isValid(String s) { 
        Stack<Character> st = new Stack<>();
        if(s == null || s.length() == 0)
            return true; 
        if(s.length() % 2 != 0){
            return false;
        }
        for(int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{')
                st.push('}');
            else if(c == '(')
                st.push(')');
            else if(c == '[')
                st.push(']');
            else if(st.isEmpty() || c != st.pop())
                return false;
        }
        return st.isEmpty();
        }
    }