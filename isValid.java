//TC - O(n);
//SC - O(n);
//LC -20
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st= new Stack<>(); 
          char cmp;
        for(int i=0;i<s.length();i++){
            if(isOpen(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(st.empty() || st.pop()!='('){
                    return false;
                }
            }
            else if(s.charAt(i)==']'){
                if(st.empty() || st.pop()!='['){
                    return false;
                }
            }
            else if(s.charAt(i)=='}'){
                if(st.empty() || st.pop()!='{'){
                    return false;
                }
            }
        }
       
        
        return st.empty();
    }
    
    public boolean isOpen(char a){
        if(a=='(' || a == '{' || a =='['){
            return true;
        }
        return false;
    }
}