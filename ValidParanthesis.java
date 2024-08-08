//TC - O(n)
//SC - O(n)
//Approach - Maintain a stack to hold the parentheses. Iterate over the string and upon hitting an incomming opening parantheses opf any type, push into the stack the paranthesis of the opposite type. 
//if the paranthesis matches then pop. Otherwise, return false. If only a closing paranthesis is given, nothing gets added to the stack hence stack is empty. 
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');

            }
            else if(c == '{'){
                st.push('}');

            }
            else if(c == '['){
                st.push(']');

            }
            else
            if(st.isEmpty() || st.peek() != c){
                return false;
            }
            else{
                st.pop();
            }
        }
       return st.isEmpty(); 
    }
}