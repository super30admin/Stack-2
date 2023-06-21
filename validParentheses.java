//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();

       map.put(')', '(');
       map.put(']', '[');
       map.put('}', '{');

       for(int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);

           if(ch == '(' || ch == '{' || ch == '[') {
               st.push(ch);
           }
           else if(!st.isEmpty() && st.peek() == map.get(ch)) {
               st.pop();
           }
           else {
               return false;
           }
       }

       if(st.isEmpty()) {
           return true;
       }
       else {
           return false;
       }

    }
}


