//Time Complexity: O(n)

class Solution {
    public boolean isValid(String s) {
        //base case -> if not even length of the string; false
        if(s.length() % 2 != 0)
            return false;
        
        Stack<Character> st = new Stack<>();
        //for every character of the string
        for(char c : s.toCharArray()) {
            //if any of the opening braces -> push to stack
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            //if closing round braces -> check the top to be opening 
            //round braces and non empty stack
            } else if(c == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            //if closing curly braces -> check the top to be opening 
            //curly braces and non empty stack
            } else if(c == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            //if closing square braces -> check the top to be opening 
            //square braces and non empty stack
            } else if(c == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }
        }
        return st.isEmpty();
    }
}