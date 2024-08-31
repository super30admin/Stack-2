/*
TC --> O(n)
SC --> O(n)
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='['|| c=='(' || c=='{'){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if(c==']' && st.peek()!='[' || c=='}' && st.peek()!='{' || c==')' && st.peek()!='('){
                    return false;
                }
                else{
                    st.pop();
                }
            }//else

        }//for

        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}

