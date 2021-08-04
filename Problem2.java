
// Time - O(N)
// Space - O(N)



class Solution {
    public boolean isValid(String s) {

        if(s == null) return false;

        Stack<Character> stk = new Stack<>();

        for(char c: s.toCharArray()) {

            if(c == '(') {
                stk.push(')');  // push the closing element for comparison later
            }
            else if(c == '{') {
                stk.push('}'); // push the closing element for comparison later
            }
            else if(c == '[') {
                stk.push(']'); // push the closing element for comparison later
            }
            else if( stk.isEmpty() || stk.pop() != c) {  // compare if the stack is empty if there is closing bracket encountered or there is no record as well as compare the popped element with the next char
                return false;
            }


        }

        return stk.isEmpty();


    }
}