/*
The time complexity is O(N) and the space complexity is O(N) where N is the length of the string.

Here, the intuition is to add the corresponding closing bracket if we encounter any opening bracket. When we see any closing one
we pop out and see if both are equal.

Yes, the solution passed all the test cases.
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='('){
                stack.push(')');
            }
            else if(curr=='['){
                stack.push(']');
            }
            else if(curr=='{'){
                stack.push('}');
            }
            else{
                if(!stack.isEmpty()){
                    if(curr!=stack.pop()){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}