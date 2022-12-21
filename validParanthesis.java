
// Time Complexity : O(n) //n is the length of the string
// Space Complexity : O(n) //n is the length of the string
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
/*
 * Check for occurence of every braces combination using stack
 */
// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap(){{
            put('(',')');
            put('[',']');
            put('{','}');
        }};
        boolean result = true;
        Stack<Character> st = new Stack();
        for( int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch=='(' || ch=='[' || ch=='{') st.push(map.get(ch));
            else if(!st.empty() && st.peek().equals(ch)) st.pop();
            else return false;
        }
        if(!st.empty() ) return false;
        return true;
    }
}