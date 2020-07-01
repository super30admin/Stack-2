//Leetcode: 20. Valid Parentheses
//Time complexity: O(n) 
//Space  Complexity: O(n)
class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='}' ){
                if(st.isEmpty() || st.pop()!='{') return false;
            }
            else if(s.charAt(i)==')' ){
                if(st.isEmpty() ||  st.pop()!='(') return false;
            }  
            else if(s.charAt(i)==']'){
                if(st.isEmpty() ||  st.pop()!='[') return false;
            }
            else{
                st.push(s.charAt(i));
            }
                                                      
        }
        return st.isEmpty();
        
    }
}