

//Time Complexity: O(n) where n is the length of the string
//Space Complexity: O(n) in worst case for the stack

//We use a stack to keep track of the opening brackets.
//When we encounter an opening bracket, we push the corresponding closing bracket onto the stack.
//When we encounter a closing bracket, we check if it matches the top of the stack.
//If it matches, we pop the top of the stack. If it doesn't match or the stack is empty, we return false.
//Finally, if the stack is empty, we return true. Otherwise, we return false.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='[')
                stk.push(']');
            else if(ch=='(')
                stk.push(')');
            else if(ch=='{')
                stk.push('}');
            else if(stk.isEmpty()||ch!=stk.pop() )
                return false;
            
        }
        return stk.isEmpty();
    }
}