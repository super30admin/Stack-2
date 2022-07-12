// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else {
                if(st.isEmpty()){
                    return false;
                }
                if((c==')' && st.pop()!='(') || (c=='}' && st.pop()!='{') || (c==']' && st.pop()!='[')){
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
}