// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


//we can maintain simple count if we have braces of only one type. plus for opein and minus for closing baracket.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of('(',')',
                '{', '}',
                '[', ']');
        char[] str = s.toCharArray();

        for(char c : str){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.empty()){
                    return false;
                }

                char popped = stack.pop();
                if(map.get(popped)!=c){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
