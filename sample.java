// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        if(s=="") return true;
        Stack<Character> st = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                if(st.isEmpty()) return false;
                char popped = st.pop();
                char mapValue = map.get(s.charAt(i));
                if(popped!=mapValue) return false;
            }
            else {
                st.push(s.charAt(i));
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
