//Time and space: O(n)
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st=new Stack();
        for(Character c : s.toCharArray()){
            if( c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else{
            if(st.isEmpty()){
                return false;
            }
            if(c==')' && st.pop()!='('){
                return false;
            }
            if(c==']' && st.pop()!='['){
                return false;
            }
            if(c=='}' && st.pop()!='{'){
                return false;
            }    
            }
            
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}