// Time Complexity : O(N) - N is no of parantheses
// Space Complexity : O(N) - N is no of parantheses; where there are only open brackets and no closing ones.
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/679810215/)
// Any problem you faced while coding this : No;
// My Notes : Check if the previous char is equal to the close one encountered; else return false
class Solution {
    public boolean isValid(String s) {
        // Create map of open and close brackets
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // push the close brackets based on its correspondent map
            if(map.keySet().contains(ch)){
                stack.push(map.get(ch));
            }else{
                // open bracket check if both are same else return false
                if(stack.isEmpty() || stack.pop()!=ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}