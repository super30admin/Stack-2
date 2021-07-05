class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
                stack.push(c);
            else if(c=='{')
                stack.push(c);
            else if(c=='[')
                stack.push(c);
            else if(c==')'){ 
                if(stack.isEmpty())  return false;
                else if(stack.peek()=='(')
                    stack.pop();
                else return false;
            }
            else if(c=='}'){ 
                if(stack.isEmpty())  return false;
                else if(stack.peek()=='{')
                    stack.pop();
                else return false;
            }
            else if(c==']'){ 
                if(stack.isEmpty())  return false;
                else if(stack.peek()=='[')
                    stack.pop();
                else return false;
            }
            
        }
        return stack.isEmpty();
            
        
    }
}
//SC:O(n)
//TC:O(n)
