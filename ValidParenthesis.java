// https://leetcode.com/problems/valid-parentheses/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty() == true){
                    return false;
                }

                char top = stack.peek();
                if(c == ')' && top == '(' || c == '}'
                        && top == '{' || c == ']' && top == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}