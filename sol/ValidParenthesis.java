package sol;

import java.util.Stack;

public class ValidParenthesis {
// Time complexity :O(n)
//	Space: O(n)
	  public boolean check(char a, char b){
	        
	        if(a=='{'&&b=='}'){
	            return true;
	        }else if (a=='(' && b==')'){
	            return true;
	        }else if (a=='['&&b==']'){
	            return true;
	        }
	        return false;
	    }
	    
	    
	    
	    public boolean isValid(String s) {
	        
	        
	        Stack<Character> st= new Stack <Character>();
	        int p=0;
	        
	        while(p<s.length()){
	            
	        if(st.isEmpty()){
	            
	            st.push(s.charAt(p));
	            p++;
	        }else if(!check(st.peek(),s.charAt(p))) {
	            
	            st.push(s.charAt(p));
	            p++;
	            
	        }else if(check(st.peek(),s.charAt(p))){
	            st.pop();
	            p++;   
	                   }
	            
	            
	        }
	        
	        
	        if(st.isEmpty()){return true;}else{return false;}
	        
	    }
}
