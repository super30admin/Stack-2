// O(n) time for traversing string one char at a time
// O(n) space for stack

class Solution {
    private HashMap<Character, Character> mappings;
    
    public Solution(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (this.mappings.containsKey(c)){ // closing bracket
                char top = stack.empty() ? '#' : stack.pop(); // get top element, if stack is empty set dummy value of #
                
                if (top != this.mappings.get(c)){ // if closing bracket, must equal the most recent opening bracket still in stack (correct order)
                    return false;
                }
            }
            else{ // opening bracket
                stack.push(c); // push to stack
            }
        }
        return stack.isEmpty();
    }
}