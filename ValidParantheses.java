class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
//If it is an opening paratheses then push it into the stack
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            else{
//if it is a closing parantheses then check if the peek is the correct opening parantheses and if yes then pop else return false
                if(st.isEmpty()) return false;
                if(s.charAt(i)==')')
                    if(st.peek()=='(')
                        st.pop();
                    else
                        return false;
                else if(s.charAt(i)==']')
                    if(st.peek()=='[')
                        st.pop();
                    else
                        return false;
                else if(s.charAt(i)=='}')
                    if(st.peek()=='{')
                        st.pop();
                    else
                        return false;
            }
        }
//if the stack is empty after the whole string traversal it means that string is valid else return false
        if(st.isEmpty())
            return true;
        return false;
    }
}


//Time complexity : O(N) since we traverse the whole string of length N 
//Space complexity : O(N) in the worst case there be only open brackets in the input string
