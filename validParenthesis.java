//Time Complexity = O(N)
//Space Complexity = O(N)
//Method: whenever we come across open bracket, push it's respective close bracket into the stack, so that when we come across close bracket, stack top element has to be the same in order for the valid parenthesis.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        if(n==0 || s == null)return true;
        for(int i =0; i< n; i++){
            char k = s.charAt(i);
            if(k=='{') stk.push('}');
            else if(k=='(') stk.push(')');
            else if(k=='[') stk.push(']');
            else if(stk.isEmpty() || stk.pop() != k)return false;
        }

        return stk.isEmpty();
    }
}