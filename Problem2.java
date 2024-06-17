package Stack-2;
// TC: O(n)
// SC :O(n)
public class Problem2 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                st.push(')');
            }
            else if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(st.empty() || st.pop()!=c){
                return false;
            }
        }
        return st.isEmpty();

    }
}
