class ValidParentheses {
    //time: O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public boolean isValid(String s) {
        
        //stack to store closing brackets correspong to input opening bracket
        Stack<Character> st = new Stack<>();
        //looping through the input string
        for(int i=0; i<s.length(); i++){
            //get current character in string
            Character c = s.charAt(i);
            //if character is an opening bracket push the closing bracket for the same in the stack
            if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(c=='('){
                st.push(')');
            }//if charcter is a closing bracket
            else{
                //stack must have an closing to bracket corresponing to current closing bracket. So stack can't be empty
                //current closing bracket should also match the type of cllosing bracket on the top of stack
                if(st.isEmpty() || st.pop()!=c) return false;
            }
            
        }
        //if still unresolved bracket remains
        if(!st.isEmpty()) return false;
        
        return true;
    }
}