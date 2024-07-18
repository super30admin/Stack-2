import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        if(s==null || s.length()==0 || s.length()%2!=0) return false;
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.size()==0) return false;
                char open = stack.pop();
                if(map.get(ch) != open) return false;
            }
        }

        return stack.size()==0;
    }
}
