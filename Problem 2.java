// Time Complexity : O(s)
// Space Complexity : O(s)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*

We will use a Stack 
1) when we encounter opening brace, we would just push them in the stack, when we encounter, closing brace, we will pop the opening one and see if they match
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            // check if opening
            if(cur == '(' || cur == '[' || cur == '{'){
                stack.push(cur);
            }
            else{ // closing brace encountered
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    char top = stack.pop();
                    // check the conditions
                    if(cur == ')' && top!='('){
                        return false;
                    }
                    else if(cur == ']' && top!='['){
                        return false;
                    }
                    else if(cur == '}' && top!='{'){
                        return false;
                    }
                }
            }

        }

        return true && stack.isEmpty();
        
    }
}