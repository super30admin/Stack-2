// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(n) where n is the length of the string

import java.util.Stack;

class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(')');
            }else if(ch == '{'){
                st.push('}');
            }else if(ch == '['){
                st.push(']');
            }else{
                if(!st.isEmpty()){
                    if(st.peek() != ch){
                        return false;
                    }else{
                        st.pop();
                    }
                }else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}