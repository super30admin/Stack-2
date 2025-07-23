class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                st.push(curr);
            }
            else{
                if(st.isEmpty()) return false;
                if(curr == ')'){
                    if(st.pop() != '(') return false;
                }else if(curr == '}'){
                    if(st.pop() != '{') return false;
                }else if(curr == ']'){
                    if(st.pop() != '[') return false;
                }
            }
        }
        return st.isEmpty();
    }
}
