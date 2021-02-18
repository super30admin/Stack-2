// Time, Space - O(N), O(N)
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length()==0) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                st.push(map.get(c));
            }
            else if(st.isEmpty()||st.pop()!=c){
                return false;
            }
        }
        
        return st.isEmpty();
    }
}
