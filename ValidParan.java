// TC - O(N)
// SC - O(N)
//Here we are using stack. We will check if its opening bracket if it is, 
//then we will push corresponding closing bracket. 
class Solution {
    public boolean isValid(String s) {
       Stack<Character> st = new Stack<>();
       if((s.length()==0) || s == null) {
           return true;
       }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            }else if(c == '['){
                st.push(']');
            }else if(c == '{'){
                st.push('}');
            }else if(st.isEmpty() || c != st.pop()){
                return false;
            }
        }
        return st.isEmpty();
    }   
}