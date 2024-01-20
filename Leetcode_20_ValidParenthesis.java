/*
approach 1: 
if we are just given 1 kind of parentheses, we can take  a count variable, tat increments when found open brace and decrements when found closing brace.

TC: O(n)
SC: O(1)

Approach -2
the above approach can also be done with Stack. When we find opening bracket, we add the relevant closing bracket to the stack. so, when we are standding at the closing bracket, pop from the stack, and compare the brackets, if same , we can keep going else return false.

TC: O(n)
SC: O(n)

This approach is not space optimized, but scalable when we are asked to solve the same problem that has all kind of parentheses.

We'll use a HashMap Datastructure, for addind pairs of brackets*/

class Solution {
    public boolean isValid(String s) {

        int n = s.length();

        if (s == null || n == 0 || n % 2 != 0)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        // stack for tracking the ope and close parentheses
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(map.get(c));
            } else {
                if (st.isEmpty() || c != st.pop())
                    return false;
            }
        }
        return st.isEmpty();
    }
}