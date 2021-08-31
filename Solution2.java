//Time complexity: O(n), where n is the length of string s. 
//Space complexity: O(n)

import java.util.*;

class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        for (char c1 : s.toCharArray()) {
            //opening brackets
            if(c1 == '(' || c1 == '{' || c1 == '[') {
                stack.push(c1);
            }
            else {
                if(stack.isEmpty()) return false;
                char c2 = stack.pop();
                //check closing brackets
                if((c1 == ')' && c2 != '(') || (c1 == ']' && c2 != '[') || (c1 == '}' && c2 != '{')) return false;
            }
        }
        return stack.isEmpty();
    }
}