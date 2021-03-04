/*
time complexity: O(n)
space complexity:O(n)

Algorithm:
whenveve opening bracket is encountred, push the opposite i.e. closing brakcet in stack.
when closing bracket is encountered, then chekc if curr closing bracket mataches with stack.pop(), if not return false. Also chekc if stack is not empty.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(')');
            }
            else if(ch == '{'){
                stack.push('}');
                
            }else if(ch == '['){
                stack.push(']');
            }
            else if(stack.isEmpty() || ch != stack.pop()){
                    return false;
                
            }
        }
        return stack.isEmpty();
    }
}