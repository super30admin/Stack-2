public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')                                                                
                stk.push(')');
            else if(c == '{')
                stk.push('}');                                                          
            else if(c == '[')
                stk.push(']');
            else
            if(!stk.isEmpty()){                                                         
                    if(stk.peek() != c){                                               
                        return false;
                    } else {
                        stk.pop();                                                          
                           }
                } else {
                return false;}                                                              
        }
        return (stk.isEmpty());                                                         
    }
}