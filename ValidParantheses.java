// Time Complexity : O(n), n is length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain a stack of chars, when opening brace, push to stack
// on closing brace kind, check stack top and if matching opening brace exists
// in the end check for stack not empty

class Solution {
    
    private HashMap<Character, Character> mappings;
    
    public Solution(){
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(!mappings.containsKey(ch)){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                    return false;
                
                char top = stack.pop();
                if(top != mappings.get(ch)){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }   
}