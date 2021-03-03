import java.util.*;

public class MatchParanthesis {

    public boolean isValid(String s) {
        
        int i = 0;
        Stack<Character> st = new Stack<>();

        while(i < s.length()){
            char c = s.charAt(i);
            if (c == '('){
                st.push(')');
            }
            else if(c == '{'){
                st.push('}');
            }
            else if (c == '['){
                st.push(']');
            }
            else if (st.isEmpty() || st.pop() != c){
                return false;
            }
        }

        return st.isEmpty();
    }
    
}
