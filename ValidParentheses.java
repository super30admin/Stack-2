//TC : O(N)
//SC : O(N)
class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0 ) return false;

        Stack <Character>st = new Stack <>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c=='(') st.add(')');
            else if(c == '{') st.add('}');
            else if(c == '[') st.add(']');
            else if(st.isEmpty() || st.pop() != c)
                return false;
        }

        return st.isEmpty();

    }
}