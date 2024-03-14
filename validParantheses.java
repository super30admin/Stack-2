import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // Tc: O(n) Sc: O(n)
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (st.isEmpty() || map.get(ch) != st.pop())
                    return false;
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}