//Place all the open brackets as closed brackets inside stack
//When any closed bracket is encountered, pop it and check whether it is matching with current closed bracket or not
//Once the same process is done for all the element, return true
//Else, return false
//TC: O(2n)
//SC: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='{'){
                stack.push('}');
            }else if(ch=='['){
                stack.push(']');
            }else{
                if(stack.isEmpty() || stack.pop()!=ch){
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        return false;
        
    }
}
