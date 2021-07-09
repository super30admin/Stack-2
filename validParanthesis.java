//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public boolean isValid(String s) {
        
        if(s.length() == 0){
            
            return false;
        }
        Stack<Character> s1 = new Stack<>();
        
        for(int i = 0; i < s.length(); i ++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                
                s1.add(')');
                
                
            }
          else   if(ch == '{'){
                
                s1.add('}');
            }
          else   if(ch == '['){
                
                s1.add(']');
            }
            else if(s1.isEmpty() || s1.pop() != ch){
                    
               
                    return false;
                }
           
                
            }
        
        
        if(!s1.isEmpty()){
            
            return false;
        }
        
        return true;
        
    }
}