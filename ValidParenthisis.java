import java.util.Stack;

//Time Complexity=O(n)
//Space Comlexity=O(n)
public class ValidParenthisis {

    public boolean isValid(String s) {
        if(s==null || s.length()<=1) return false;

        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }else{
                    if(st.peek()=='(' && c!=')') return false;
                    if(st.peek()=='[' && c!=']') return false;
                    if(st.peek()=='{' && c!='}') return false;
                    st.pop();
                }
            }
        }

        if(!st.isEmpty()) return false;
        return true;
    }
}
