class Solution {
    private boolean iscorrect(char a1, char a2){
        if(a1 == '{' && a2 == '}')
            return true;
        
        if(a1 == '[' && a2 == ']')
            return true;
        
        if(a1 == '(' && a2 == ')'){
            return true;
        }
        return false;
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                stack.add(ch);
            }
            if(ch == ']' || ch == '}' || ch == ')'){
                if(stack.isEmpty()){
                    return false;
                }else if(!iscorrect(stack.pop(), ch)){
                    return false;
                }
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
       
    }
}