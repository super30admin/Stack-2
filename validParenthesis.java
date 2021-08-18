// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int pairCount = 0;
        Map<Character, Character> test1 = new HashMap<Character, Character>() {{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(test1.containsKey(curr)) {
                if(st.isEmpty()) return false;
                if(st.peek() != test1.get(curr)) return false;
                else st.pop();
                pairCount--;
            } else {
                st.add(curr);
                pairCount++;
            }
        }
        if(pairCount == 0)
            return true;
        else
            return false;
    }
}
