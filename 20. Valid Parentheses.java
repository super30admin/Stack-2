// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                s.add(c);
                continue;
            }
            if(s.isEmpty()) return false;
            char t = s.pop();
            switch(c){
                case ')':
                    if(t != '(') return false;
                    break;
                case '}':
                    if(t != '{') return false;
                    break;
                case ']':
                    if(t != '[') return false;
                    break;
                default: return false;
            }
        }

        return s.isEmpty();
    }
}
