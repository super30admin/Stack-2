// TC = O(n)
class Solution {
    // public boolean isValid(String s) {
    //     Stack<Character> st = new Stack<>();
    //     for(int i=0;i<s.length();i++){
    //         if(s.charAt(i) == '(') st.push(')');
    //         else if(s.charAt(i) == '{') st.push('}');
    //         else if(s.charAt(i) == '[') st.push(']');
    //         else if(!st.isEmpty() && st.peek() != s.charAt(i)) {
    //             return false;
    //         }else if(!st.isEmpty() && st.peek() == s.charAt(i)){
    //             st.pop();
    //         }else if(st.isEmpty() && s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']'){
    //             return false; // check that there is no opening brace as stack is empty and hence 
    //         }
    //     }
    //     if(st.isEmpty()) return true;
    //     return false;
    // }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') st.push(')');
            else if(s.charAt(i) == '{') st.push('}');
            else if(s.charAt(i) == '[') st.push(']');
            // below case basically says that the stack cant be empty when there is a closing brace character coming in as the input and also it should return false in case when the incoming closing brace character does not match the top element of the stack
            else if(st.isEmpty() || s.charAt(i)!=st.pop()){
                return false; // check that there is no opening brace as stack is empty and hence 
            }
        }
        return st.isEmpty();
    }
}