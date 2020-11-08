import java.util.*;
/*
TC: O(N) - N - length of String
SC: O(N) - worst case the string could contains all open braces.

1. Keep a stack of open parentheses.
2. When we encounter a closing bracket, check if the top of the stack has corresponding open bracket and then pop it. 
3. Inorder to check there were no outstanding open brackets, check if stack is empty afer traversing the complete string.

*/
public class ValidParentheses {

    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0) return true;
        
        Stack<Character> stk = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('{');
        set.add('[');
        
        for(char c : s.toCharArray()){
            
            if(set.contains(c)){
                stk.push(c);
            }else{
                if(stk.isEmpty()) return false;
                if(c == ']' && stk.peek() != '[') return false;
                else if(c == '}' && stk.peek() != '{') return false;
                else if(c == ')' && stk.peek() != '(') return false;
                else
                    stk.pop();
            }
        }
        
        return stk.isEmpty() ? true : false;
    }
    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{{}(){}"));
    }
}
