//Time complexity:O(n)
//space complexity:O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char si=s.charAt(i);
            if(si=='(') st.push(')');
            else if (si=='[') st.push(']');
            else if(si=='{') st.push('}');
            else if(st.isEmpty()|| st.pop()!=si) return false; 
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
