/**
Leet Code Submitted : YES
Time Complexity : O(N)
Space Complexity : O(N/2)

The idea is to use stack to store the close parenthesis at each open iteration such that at each iteration after encountering any close parenthesis check stack.peek() to see the top level character in the stack and accordingly return values.
At the end stack should be empty to return true.

**/
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() < 1)
            return true;
        
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                st.push(c);
            }else{
                if(!st.isEmpty() && map.get(st.peek()) == c){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
}
