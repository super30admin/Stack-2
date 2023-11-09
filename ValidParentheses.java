//TC will be O(n), n is the length of the String
//SC will be O(n)

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        Stack<Character> st= new Stack<>();
        for(int i=0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            }
            else if(c == '{'){
                st.push('}');
            }
            else if(c == '['){
                st.push(']');
            }
            else{
                if(st.isEmpty() || st.pop() != c){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses obj = new ValidParentheses();
        String s = "()";
        System.out.println(obj.isValid(s));
    }
}