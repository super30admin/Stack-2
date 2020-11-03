class Solution {

    // TC:  O(n)
    // SC:  O(n)

    // We have 4 methods
        //     1. HashMap - OpenBraces as Keys && ClosedBraces as Values
        //     2. HashMap - ClosedBraces as Keys && OpenBraces as Values
        //     3. Replacing all the closed - (), [], {} with emptyspace "" and
        //         check if string size is 0 at the end
        //     4. Coding 3 or 4 checks redundantly

    public boolean isValid(String s) {        
        // Stack<Character> stack = new Stack<>();
        // Map<Character, Character> map = new HashMap<>();
        // map.put(')', '(');
        // map.put(']', '[');
        // map.put('}', '{');```
        
        // for(int i = 0; i < s.length(); i++){
        //     char c = s.charAt(i);
        //     if(map.containsKey(c)){                
        //         char top = stack.isEmpty() ? '#' : stack.pop();
        //         if(top != map.get(c)) return false;
        //     }else 
        //         stack.push(c);
        // }
        // return stack.isEmpty();
        
// ==============================================================================
    // while(s.length() >= 2 && (s.contains("()") || s.contains("[]") || s.contains("{}"))){
    //     s = s.replace("()", "");
    //     s = s.replace("[]", "");   
    //     s = s.replace("{}", "");
    // }
    //     return s.isEmpty();
// ==============================================================================
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[')    stack.push(c);
            else if( c == '}' && !stack.isEmpty() && stack.peek() == '{' ) stack.pop();
            else if( c == ']' && !stack.isEmpty() && stack.peek() == '[' ) stack.pop();
            else if( c == ')' && !stack.isEmpty() && stack.peek() == '(' ) stack.pop();
            else return false;
        }
        return stack.isEmpty();        
    }
}