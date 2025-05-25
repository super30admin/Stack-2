/*
 * Time Complexity: O(n) => To Iterate
 * Space Complexity: O(n) => Stack Processing
 */
class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c== '{' || c == '(' || c == '['){
                myStack.add(c);
            }

            else{
                if(myStack.isEmpty())
                    return false;
                char top = myStack.pop();
                if(c == ')' && top !='(')
                    return false;
                if(c == ']' && top !='[')
                    return false;
                if(c == '}' && top !='{')
                    return false;
            }
        }
        return myStack.isEmpty();
    }
}