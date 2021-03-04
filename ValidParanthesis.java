class ValidParanthesis {
    
    /*
        Time : O(N) - N being length of a string
        Space : O(N) - worst case there are only opening brackets so we are storing everything in stack
        Leetcode : YES
    */
  
    /*
      Approach :
        - For each of LAST unresolved bracket we need to resolve it FIRST. 
        - use stack and store opening brackets in stack. 
        - As you iterate if you find closing bracket then remove respective opening bracket form stack and. 
        - if stack top is not equal to current closing's respective bracket then return false;
        - in the end if stack isn't empty then return false.
    */
    public boolean isValid(String s) {
        if(s == null) return false;
        int n = s.length();
        if(n == 0) return true;
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < n ; i++ ){
            char c = s.charAt(i);
            if(!stk.isEmpty()){
                char stkChar = stk.peek();
                
                if( c == ')'){
                    if(stkChar != '(') return false;
                }else if(c == '}'){
                    if(stkChar != '{') return false;
                }else if(c == ']'){
                    if(stkChar != '[') return false;
                }else{
                    stk.push(c);
                    continue;
                }
                
                stk.pop();
                                
            }else{
                stk.push(c);
            }
            
        }
        
        return stk.isEmpty();
        
    }
}
