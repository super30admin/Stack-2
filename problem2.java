package Stack-2;

public class problem2 {
    class Solution {
        //TC:- O(n)
        //SC:- O(n)
        public boolean isValid(String s) {
            Stack<Character>st = new Stack<>();
            
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                
                if(c=='}'){
                    if(!st.isEmpty()&& st.peek()=='{'){
                        st.pop();
                    }else{
                        st.add('}');
                    }
                } else if(c==']'){
                    if(!st.isEmpty() && st.peek()=='['){
                        st.pop();
                    }else{
                        st.add(']');
                    }
                }else if(c==')'){
                    if(!st.isEmpty() && st.peek()=='('){
                        st.pop();
                    }else{
                        st.add(')');
                    }
                }else{
                st.add(c);
                }
            }
            
            if(st.isEmpty()){return true;}
            return false;
        }
    }
}
