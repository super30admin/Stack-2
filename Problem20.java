import java.util.Stack;

//TC=O(n)
//SC=O(n)
public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(')
                stk.push(')');
            else if(c=='{')
                stk.push('}');
            else if(c=='[')
                stk.push(']');
            else
            if(stk.isEmpty() || stk.pop() != c)
                return false;
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        Problem20 problem20=new Problem20();
        System.out.println(problem20.isValid("()[]{}"));
        System.out.println(problem20.isValid("(]{}"));
    }
}
