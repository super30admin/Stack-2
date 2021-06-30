// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') st.push(c);
            else if(st.isEmpty() || map.get(c) != st.pop()) return false;
        }
        return st.isEmpty();
    }
}
