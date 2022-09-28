//TC: O(n) string length
//SC: O(n)

// approach: while iterating if encountered a forward brace, then place the replica of that into the stack 
//until my stack is empty or the current character != st.pop()

class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length() ==0)
            return true;
        if(s.length()%2!=0)
            return false;
        Stack<Character> st = new Stack<>();
        for(int i=0;i< s.length();i++){
        char ch = s.charAt(i);
            if(ch=='{')
                st.push('}');
            else if(ch == '[')
                st.push(']');
            else if(ch == '(')
                st.push(')');
            else if(st.isEmpty() || ch!=st.pop())
                return false;
        }
        if(!st.isEmpty())
            return false;
        return true;
    }
}