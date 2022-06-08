import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {

    // TC : O(n) n - input string length
    // SC : O(1)
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int i=0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                }else {
                    return false;
                }
            }

            i++;
        }

        return stack.isEmpty();
    }
}
