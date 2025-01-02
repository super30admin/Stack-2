// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    //TC:O(n)
    //SC:O(n)
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == '('){
                st.add(')');
            }else if(curr == '{'){
                st.add('}');
            } else if(curr == '['){
                st.add(']');
            }else{
                //it is some closuing character
                if(st.isEmpty() || curr != st.peek()){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
