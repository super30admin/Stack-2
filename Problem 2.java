
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Used hashmap for effective access to the characters. check if the character exists in the map and then add it's closing into the stack. When there is a closing bracket pop the element from the top

class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> hp = new HashMap<>();
        Stack<Character> st = new Stack<>();

        hp.put('(', ')');
        hp.put('{', '}');
        hp.put('[', ']');

        for (char ch : s.toCharArray()) {
            if (hp.get(ch) != null) {
                st.push(hp.get(ch));
            } else {
                if (st.isEmpty() || ch != st.pop()) {
                    return false;
                }
            }
        }

        return st.isEmpty();

    }

}