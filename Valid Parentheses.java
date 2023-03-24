class Solution {
	//Time: O(n)
	//Space: O(n)
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
                
            }
            
            else if(!st.empty()){
                
                char popped = st.pop();
                
                if(c == ')' && popped != '(' ||
                   c == '}' && popped != '{'||
                   c == ']' && popped != '['){
                    
                    return false;
                    
                }
            }
            
            else{
                return false;
            }
        }
        
        if(!st.empty()){
            return false;
        }
        
        return true;
    }
}