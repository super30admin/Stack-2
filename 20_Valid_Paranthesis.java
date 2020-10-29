    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/valid-parentheses/
    Time Complexity for operators : o(n) .. number of CHARACTERS in string
    Extra Space Complexity for operators : o(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach: 
                              
            Approach   
                    A. Create Hasmap and Hashset of opeing and closing brackets.
                    B. Then iterate thorugh the string character by character
                    C. If it is opening bracket then push it into stack.
                    D. If not check stack is empty or not if not then check hashmap's respecting character
                        with the stack peek. if not equal the return false;
                    E. At the end return stack is emoty or not.

       */

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        HashSet<Character> opening = new HashSet<>(){{add('{');add('[');add('(');}};
        HashMap<Character,Character> closing = new HashMap<>(){{put('}','{');put(']','[');put(')','(');}};
        // for(int x=0;x<s.length();x++){
        //     char ch = s.charAt(x);
        //     if ("{[(".contains(String.valueOf(ch))) {
        //         stack.push(ch);
        //     }else if(!stack.isEmpty()){
        //         if(ch == '}' && stack.pop()!='{')
        //             return false;
        //         else if(ch == ']' && stack.pop()!='[')
        //             return false;
        //         else if(ch == ')' && stack.pop()!='(')
        //             return false;
        //     }else{
        //         return false;
        //     }
        // }
        
        
        for(int x=0;x<s.length();x++){
            char ch = s.charAt(x);
            if (opening.contains(ch)) {
                stack.push(ch);
            }else if(!stack.isEmpty()){
                if(stack.pop()!=closing.get(ch))
                    return false;
            }else{
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}