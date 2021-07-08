import java.util.Stack;
//time complexity : O(n)
//space complaxity : O(n)
//leet code : yes
//steps : implemented using stack
public class ValidParantheses20 {

        public boolean isValid(String s) {
            
            if(s.length() ==0||s==null) return true;
            Stack<Character> stack = new Stack<>();
            
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                
                if(ch=='(') stack.push(')');
                if(ch=='{') stack.push('}');
                if(ch=='[') stack.push(']');
                
                if(ch==']' || ch=='}' || ch==')'){
                    if(stack.isEmpty()) return false;
                    if(ch!=stack.pop()) return false;
                }
                
            }
            
            return stack.isEmpty();
            
        }
    }