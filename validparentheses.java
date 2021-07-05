//Time Complexity:O(N)
//SPace Complexity:O(N)
//Approach- I'll iterate through the given string character by character and whenever I encounter an open parentheses, I'll push the corresponding closing parentheses into the stack. Whenever I encounter a closing parentheses, I'll check if that parentheses is equal to the parentheses at the top of the stack. If yes, I'll continue, Else, I'll return false.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='['){
                stack.push(']');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(c=='('){
                stack.push(')');
            }
            else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}